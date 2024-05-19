package Cabinet;
import java.util.Date;

public class RendezVous {
	  private Patient patient;
	    private Date date;

	    public RendezVous(Patient patient, Date date) {
	        this.patient = patient;
	        this.date = date;
	    }

	    // Getters et setters
	    public Patient getPatient() {
	        return patient;
	    }

	    public Date getDate() {
	        return date;
	    }
}
