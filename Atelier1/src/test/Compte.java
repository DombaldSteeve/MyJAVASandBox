package test;

public abstract class Compte  {
	
	 protected double solde;
	 
	 
	 /*******   CONSTRUCTEUR   ******/
	 
	 public Compte(double solde) {
	 	super();
		this.solde = solde;
	}
	 
	 
	 
	 /******* METHODE ********/
		
	 public void deposit(int depot) {
			solde = depot + solde;
			System.out.println("Vous venez de faire un dep�t de " + depot + "�. Votre nouveau solde est donc de " + solde + "�.");
		}
	
	 public void affiche() {
		 System.out.println(toString());
	 }
	 
}
