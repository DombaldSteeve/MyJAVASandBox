package Immeuble;

public class Immeuble {
	private Etage[] etages;
	private int nbAppartPerEtage;
	private int nbEtages;
	
	public Immeuble(int nbAppartPerEtage, int nbEtages) {
		super();
		this.nbAppartPerEtage = nbAppartPerEtage;
		this.nbEtages = nbEtages;
		createEtage();
	}
	
	public Etage[] getEtages() {
		return etages;
	}

	private void createEtage() {
		etages = new Etage[nbEtages];
		for (int i = 0 ; i < nbEtages ; i++) {
			etages[i] = new Etage(i,nbAppartPerEtage);
		}
	}
	
	public void display() {
		for (Etage etage:etages) {
			System.out.println("[Etage "+etage.getNumero()+"] -- "+etage.getApartsString());
		}
	}
}
