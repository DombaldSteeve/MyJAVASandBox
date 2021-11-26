package Vehicule;

public class Cabriolet extends Voiture {
	
	
	private static final int NB_PLACES_CABRIOLET = 2;

	
	
	public Cabriolet(String marque, String modele, int prix) {
		super(marque, modele, prix, NB_PLACES_CABRIOLET);
		
	}
	
	
	protected void freiner() {
		System.out.println("Je suis un cabriolet et je freine !");
	}
	
	
	public String toString() {
		return getMarque() + " " + getModele() + " " + getPrix() + "€ avec " + NB_PLACES_CABRIOLET + " places assises.";
	}
}
