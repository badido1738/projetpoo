package Cabinet;
import java.util.ArrayList;

public class DossierMedical {
	  private Patient patient;
	    private ArrayList<Consultation> consultations;

	    public DossierMedical(Patient patient, ArrayList<Consultation> consultations) {
	        this.patient = patient;
	        this.consultations = consultations;
	    }

	    public void ajouterConsultation(Consultation consultation) {
	        consultations.add(consultation);
	    }

	    
	    public Patient getPatient() {
	        return patient;
	    }

	    public ArrayList<Consultation> getConsultations() {
	        return consultations;
	    }
	    public void afficherDossierMedical() {
	        System.out.println("Dossier médical de " + patient.getNom() + " " + patient.getPrenom());
	        for (Consultation consultation : consultations) {
	            System.out.println("Date : " + consultation.getDate());
	            System.out.println("Observation : " + consultation.getObservation());
	            System.out.println("Ordonnance : " + consultation.getOrdonnance());
	            System.out.println("Certificat médical : " + consultation.getCertificatMedical());
	            System.out.println("-------------------");
	        } 
}}
