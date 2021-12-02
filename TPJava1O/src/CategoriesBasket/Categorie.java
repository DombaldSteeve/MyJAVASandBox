package CategoriesBasket;

import java.util.Scanner;

public class Categorie {
	
	
	public static void main(String[] args) {
		
	int a = 0;
	Scanner scanner = new Scanner(System.in);
	System.out.print("Veuillez renseigner l'âge du joueur -> ");
	a = scanner.nextInt();

	
	if (a < 6 ) {
		System.out.println("Ce joueur doit évoluer en : Mini-Poussin.");
	} else if (a >= 6 && a < 8) {
		System.out.println("Ce joueur doit évoluer en : Poussin.");
	} else if (a >= 8 && a < 10) {
		System.out.println("Ce joueur doit évoluer en : Pupille.");
	} else if (a >= 10 && a < 12) {
		System.out.println("Ce joueur doit évoluer en : Minime.");
	} else if (a >= 12 ) {
		System.out.println("Ce joueur doit évoluer en : Cadet.");
	}

} 
}
