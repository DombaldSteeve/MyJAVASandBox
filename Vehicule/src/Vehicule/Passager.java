package Vehicule;

public class Passager {
	
	private String nom;
	private String prenom;
	
	
	/***** CONSTRUCTEUR     *****/
	
	public Passager(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	/*****     Getters     *****/
	
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	
	/*****     Setters     *****/
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return  "\n" + nom + " " + prenom;
	}
	
}
