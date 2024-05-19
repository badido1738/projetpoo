package Cabinet;

import java.util.Date;

public class Consultation {
	private Date date;
    private String observation;
    private String ordonnance;
    private String certificatMedical;

    public Consultation(Date date, String observation, String ordonnance, String certificatMedical) {
        this.date = date;
        this.observation = observation;
        this.ordonnance = ordonnance;
        this.certificatMedical = certificatMedical;
    }

    
    public Date getDate() {
        return date;
    }

    public String getObservation() {
        return observation;
    }

    public String getOrdonnance() {
        return ordonnance;
    }
    public String getCertificatMedical() {
        return certificatMedical;
    }
}
