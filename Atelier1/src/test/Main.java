package test;

public class Main {

	public static void main(String[] args) {
		
		
		 CompteBancaire cb = new CompteBancaire(1500, -500);
		
		 cb.deposit(600);
		 cb.withdraw(3500);
		 
		 cb.affiche();
		 
		 System.out.println();
			
		 CompteEpargne ce = new CompteEpargne(2000, 0.3);
			
		 ce.deposit(600);
		 ce.withdraw(800);
		 
		 ce.affiche();
	
	}
}
