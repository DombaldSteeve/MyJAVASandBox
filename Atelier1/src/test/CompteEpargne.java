package test;

public class CompteEpargne extends Compte {
	
	
	private double tauxInt;
	
	
	public CompteEpargne(double solde, double tauxInt) {
		super(solde);
		this.tauxInt = tauxInt;
	}

	/******* METHODE ********/
	
	
	public void withdraw(int retrait) {
		
		if( (solde-retrait) <= 0 ) {
			System.out.println("Vous n'�tes pas autoris� � retirer autant sur ce compte.");
		} else {
			solde = solde - retrait;
			System.out.println("Vous venez de faire un retrait de " + retrait + "�. Votre nouveau solde est donc de " + solde + "�.");
		}		
	}
	
	public String toString() {
		return "Votre solde est de " + solde + "�. Et votre taux d'inter�t est de " + tauxInt;
		}

}
