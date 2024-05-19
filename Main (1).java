package Cabinet;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 GestionCabinetMedical cabinet = new GestionCabinetMedical();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nQue voulez-vous faire ?");
	            System.out.println("1. Ajouter un patient");
	            System.out.println("2. Ajouter un rendez-vous");
	            System.out.println("3. Ajouter une consultation");
	            System.out.println("4. Afficher la liste des patients");
	            System.out.println("5. Afficher la liste des dossiers médicaux");
	            System.out.println("6. Afficher la liste des rendez-vous");
	            System.out.println("7. Mettre à jour un patient");
	            System.out.println("8. Supprimer un patient");
	            System.out.println("9. Quitter");
	            System.out.print("Votre choix : ");

	            int choix = scanner.nextInt();
	            scanner.nextLine(); // Consommer le caractère de fin de ligne

	            switch (choix) {
	                case 1:
	                    cabinet.ajouterPatient();
	                    break;
	                case 2:
	                    cabinet.ajouterRendezVous();
	                    break;
	                case 3:
	                    cabinet.ajouterConsultation();
	                    break;
	                case 4:
	                    afficherPatients(cabinet);
	                    break;
	                case 5:
	                    cabinet.afficherDossiersMedicaux();
	                    break;
	                case 6:
	                    cabinet.afficherRendezVous();
	                    break;
	                case 7:
	                    mettreAJourPatient(cabinet);
	                    break;
	                case 8:
	                    supprimerPatient(cabinet);
	                    break;
	                case 9:
	                    System.out.println("Au revoir !");
	                    return;
	                default:
	                    System.out.println("Choix invalide. Veuillez réessayer.");
	            }
	        }
	    }

	    private static void afficherPatients(GestionCabinetMedical cabinet) {
	        ArrayList<Patient> patients = cabinet.getPatients();
	        if (patients.isEmpty()) {
	            System.out.println("Aucun patient enregistré.");
	        } else {
	            System.out.println("Liste des patients :");
	            for (Patient patient : patients) {
	                System.out.println("- " + patient.getNom() + " " + patient.getPrenom());
	            }
	        }
	    }

	    private static void mettreAJourPatient(GestionCabinetMedical cabinet) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Entrez le nom du patient à mettre à jour :");
	        String nom = scanner.nextLine();
	        System.out.println("Entrez le prénom du patient à mettre à jour :");
	        String prenom = scanner.nextLine();

	        Patient patient = cabinet.rechercherPatient(nom, prenom);
	        if (patient == null) {
	            System.out.println("Patient non trouvé.");
	            return;
	        }

	        System.out.println("Entrez les nouvelles informations du patient :");
	        Patient nouveauPatient = saisirInformationsPatient();
	        cabinet.mettreAjourPatient(nouveauPatient);
	        System.out.println("Patient mis à jour avec succès.");
	    }

	    private static void supprimerPatient(GestionCabinetMedical cabinet) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Entrez le nom du patient à supprimer :");
	        String nom = scanner.nextLine();
	        System.out.println("Entrez le prénom du patient à supprimer :");
	        String prenom = scanner.nextLine();

	        Patient patient = cabinet.rechercherPatient(nom, prenom);
	        if (patient == null) {
	            System.out.println("Patient non trouvé.");
	            return;
	        }

	        cabinet.supprimerPatient(patient);
	        System.out.println("Patient supprimé avec succès.");
	    }

	    private static Patient saisirInformationsPatient() {
	        Scanner scanner = new Scanner(System.in);
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
	        return new Patient(nom, prenom, telephone, antecedentsMedicaux, antecedentsChirurgicaux, poids, taille, allergies);
	    }
	}
	
	   