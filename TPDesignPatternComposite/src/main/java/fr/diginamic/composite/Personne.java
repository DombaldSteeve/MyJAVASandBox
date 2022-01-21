package fr.diginamic.composite;

public class Personne implements IEntite {
	
    private String nom;
    private String prenom;


    public void execute() {
        System.out.println("Je suis " + getPrenom() + "!");
    }
    
    public Personne() {
    	
    }
    
    public Personne(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @Override
    public String toString() {
        return "Personne [nom=" + nom + ", prenom=" + prenom + "\n]";
    }
}

