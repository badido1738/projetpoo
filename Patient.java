package Cabinet;
import java.util.ArrayList;



public class Patient {
	  private String nom;
	    private String prenom;
	    private String telephone;
	    private String antecedentsMedicaux;
	    private String antecedentsChirurgicaux;
	    private double poids;
	    private double taille;
	    private ArrayList<String> allergies;
	    
	    public Patient(String nom, String prenom, String telephone, String antecedentsMedicaux, String antecedentsChirurgicaux, double poids, double taille, ArrayList<String> allergies) {
	        this.nom = nom;
	        this.prenom = prenom;
	        this.telephone = telephone;
	        this.antecedentsMedicaux = antecedentsMedicaux;
	        this.antecedentsChirurgicaux = antecedentsChirurgicaux;
	        this.poids = poids;
	        this.taille = taille;
	        this.allergies = allergies;
}  public String getNom() {
    return nom;
}

public String getPrenom() {
    return prenom;
}

public String getTelephone() {
    return telephone;
}

public String getAntecedentsMedicaux() {
    return antecedentsMedicaux;
}

public String getAntecedentsChirurgicaux() {
    return antecedentsChirurgicaux;
}

public double getPoids() {
    return poids;
}

public double getTaille() {
    return taille;
}

public ArrayList<String> getAllergies() {
    return allergies;
} 






}