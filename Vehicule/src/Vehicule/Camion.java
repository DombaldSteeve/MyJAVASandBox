package Vehicule;

public class Camion extends Vehicule {
	
	private double poidsMaximumRoulant;
	
	protected int NB_ROUES_CAMION = 6;
	
	
	public Camion(String marque, String modele, int prix, Double poidsMaximumRoulant) {
		super(marque, modele, prix);
		this.poidsMaximumRoulant = poidsMaximumRoulant;
	}


	public Double getPoidsMaximumRoulant() {
		return poidsMaximumRoulant;
	}


	public void setPoidsMaximumRoulant(int poidsMaximumRoulant) {
		this.poidsMaximumRoulant = poidsMaximumRoulant;
	}
	
	protected void freiner() {
		System.out.println("Je suis un camion et je freine !");
	}
	
	
	public String toString() {
		return getMarque() + " " + getModele() + " " + getPrix() + "€ avec " + poidsMaximumRoulant + "t autorisé pour transport et comporte " + NB_ROUES_CAMION + " roues. " ;
	}

}
