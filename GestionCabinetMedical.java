package Cabinet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GestionCabinetMedical {
	 private ArrayList<Patient> patients;
	    private ArrayList<DossierMedical> dossiersMedicaux;
	    private ArrayList<RendezVous> rendezVous;
	    private Scanner scanner;
	    private SimpleDateFormat dateFormat;

	    public GestionCabinetMedical() {
	        this.patients = new ArrayList<>();
	        this.dossiersMedicaux = new ArrayList<>();
	        this.rendezVous = new ArrayList<>();
	        this.scanner = new Scanner(System.in);
	        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	    }

	  

	        public void ajouterPatient() {
	            System.out.println("Entrez le nom du patient :");
	            String nom = scanner.nextLine();
	            System.out.println("Entrez le prénom du patient :");
	            String prenom = scanner.nextLine();
	            System.out.println("Entrez le numéro de téléphone du patient :");
	            String telephone = scanner.nextLine();
	            System.out.println("Entrez les antécédents médicaux du patient (ou 'aucun') :");
	            String antecedentsMedicaux = scanner.nextLine();
	            System.out.println("Entrez les antécédents chirurgicaux du patient (ou 'aucun') :");
	            String antecedentsChirurgicaux = scanner.nextLine();
	            System.out.println("Entrez le poids du patient :");
	            double poids = Double.parseDouble(scanner.nextLine());
	            System.out.println("Entrez la taille du patient :");
	            double taille = Double.parseDouble(scanner.nextLine());
	            System.out.println("Entrez les allergies du patient (séparées par des virgules) :");
	            String[] allergiesArray = scanner.nextLine().split(",");
	            ArrayList<String> allergies = new ArrayList<>();
	            for (String allergie : allergiesArray) {
	                allergies.add(allergie.trim());
	            }
	            Patient patient = new Patient(nom, prenom, telephone, antecedentsMedicaux, antecedentsChirurgicaux, poids, taille, allergies);
	            patients.add(patient);
	            DossierMedical dossier = new DossierMedical(patient, new ArrayList<>());
	            dossiersMedicaux.add(dossier);
	            System.out.println("Patient ajouté avec succès.");
	        }

	        public Patient rechercherPatient(String nom, String prenom) {
	            for (Patient patient : patients) {
	                if (patient.getNom().equals(nom) && patient.getPrenom().equals(prenom)) {
	                    return patient;
	                }
	            }
	            return null;
	        }

	        public void mettreAjourPatient(Patient patient) {
	            int index = patients.indexOf(patient);
	            if (index != -1) {
	                patients.set(index, patient);
	            }
	        }

	        public void supprimerPatient(Patient patient) {
	            patients.remove(patient);
	        }
	        public ArrayList<Patient> getPatients() {
	            return patients;
	        }
	        public void ajouterRendezVous() {
	            System.out.println("Entrez le nom du patient :");
	            String nom = scanner.nextLine();
	            System.out.println("Entrez le prénom du patient :");
	            String prenom = scanner.nextLine();

	            Patient patient = rechercherPatient(nom, prenom);
	            if (patient == null) {
	                System.out.println("Patient non trouvé.");
	                return;
	            }

	            System.out.println("Entrez la date du rendez-vous (format : dd/MM/yyyy HH:mm) :");
	            String dateStr = scanner.nextLine();
	            Date date = parseDate(dateStr);
	            if (date == null) {
	                System.out.println("Format de date invalide.");
	                return;
	            }
	            RendezVous rdv = new RendezVous(patient,date);  
	            rendezVous.add(rdv);
	            System.out.println("Rendez-vous ajouté avec succès.");
	        }

	        public void ajouterConsultation() {
	            System.out.println("Entrez le nom du patient :");
	            String nom = scanner.nextLine();
	            System.out.println("Entrez le prénom du patient :");
	            String prenom = scanner.nextLine();

	            Patient patient = rechercherPatient(nom, prenom);
	            if (patient == null) {
	                System.out.println("Patient non trouvé.");
	                return;
	            }

	            DossierMedical dossier = rechercherDossierMedical(patient);
	            if (dossier == null) {
	                System.out.println("Dossier médical non trouvé pour ce patient.");
	                return;
	            }

	            System.out.println("Entrez la date de la consultation (format : dd/MM/yyyy HH:mm) :");
	            String dateStr = scanner.nextLine();
	            Date date = parseDate(dateStr);
	            if (date == null) {
	                System.out.println("Format de date invalide.");
	                return;
	            }

	            System.out.println("Entrez l'observation :");
	            String observation = scanner.nextLine();
	            System.out.println("Entrez l'ordonnance :");
	            String ordonnance = scanner.nextLine();
	            System.out.println("Entrez le certificat médical (ou 'aucun') :");
	            String certificatMedical = scanner.nextLine();

	            Consultation consultation = new Consultation(date, observation, ordonnance, certificatMedical);
	            dossier.ajouterConsultation(consultation);
	            System.out.println("Consultation ajoutée avec succès.");
	        }

	        private DossierMedical rechercherDossierMedical(Patient patient) {
	            for (DossierMedical dossier : dossiersMedicaux) {
	                if (dossier.getPatient().equals(patient)) {
	                    return dossier;
	                }
	            }
	            return null;
	        }

	        public void afficherDossiersMedicaux() {
	            for (DossierMedical dossier : dossiersMedicaux) {
	                dossier.afficherDossierMedical();
	            }
	        }

	        public void afficherRendezVous() {
	            for (RendezVous rdv : rendezVous) {
	                System.out.println("Date : " + rdv.getDate());
	                System.out.println("Patient : " + rdv.getPatient().getNom() + " " + rdv.getPatient().getPrenom());
	                System.out.println("-------------------");
	            }
	        }

	        private Date parseDate(String dateStr) {
	            try {
	                return dateFormat.parse(dateStr);
	            } catch (ParseException e) {
	                return null;
	            }
	        }
}
