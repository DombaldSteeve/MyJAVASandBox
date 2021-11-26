package Vehicule;

public class Voiture extends Vehicule {

	private int nombreDePlaces;
	
	
	public Voiture(String marque, String modele, int prix, int nombreDePlaces) {
		super(marque, modele, prix);
		this.nombreDePlaces = nombreDePlaces;
		
	}
	
	
	public int getNbrDePlaces() {
		return nombreDePlaces;
	}
	
	public void setNbrDePlaces(int nombreDePlaces) {
		this.nombreDePlaces = nombreDePlaces;
	}
	
	 protected void freiner() {
		System.out.println("Je suis une voiture et je freine !");
	}
	
	
	public String toString() {
		
		String sReturn = getMarque() + " " + getModele() + " " + getPrix() + "€ avec " + nombreDePlaces + 
				" places assises " + NB_ROUES + " roues.\nIl y de présent dans cette voiture : " + afficherPassagers() + " ";
		
		return sReturn;
	}

}

