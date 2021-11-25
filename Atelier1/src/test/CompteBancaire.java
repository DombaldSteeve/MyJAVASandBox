package test;

public class CompteBancaire extends Compte {
	
	
	/*  protected double solde; */
	private double autorisation;
	 
	
	 /*******   CONSTRUCTEUR   ******/
	 
	 public CompteBancaire(double solde, double autorisation) {
		 	super(solde);
			this.autorisation = autorisation;
		}
	 
	 
	/******* METHODE ********/
	
	public void withdraw(int retrait) {
		
		if( (solde-retrait) <= autorisation ) {
			System.out.println("Vous n'�tes pas autoris� � retirer sur ce compte.");
		} else {
			solde = solde - retrait;
			System.out.println("Vous venez de faire un retrait de " + retrait + "�. Votre nouveau solde est donc de " + solde + "�.");
		}		
	}
	
	public String toString() {
		return "Votre solde est de " + solde + "�, et votre autorisation de d�couvert est de " + autorisation;
		}
	
}
