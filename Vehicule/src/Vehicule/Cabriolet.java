package Vehicule;

public class Cabriolet extends Voiture {
	
	
	protected static final int NB_PLACES = 2;

	
	
	public Cabriolet(String marque, String modele, int prix) {
		super(marque, modele, prix, NB_PLACES);
		
	}

	
	protected void freiner() {
		System.out.println("Je suis un cabriolet et je freine !");
	}
	
	
	public String toString() {
		return getMarque() + " " + getModele() + " " + getPrix() + "€ avec " + NB_PLACES + " places assises.";
	}
}
