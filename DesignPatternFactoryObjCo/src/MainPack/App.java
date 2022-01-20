package MainPack;

import ObjetsClass.Fabrique;
import ObjetsClass.ObjetConnecte;

public class App {
	
	public static void main(String[] args) {
		
		Fabrique fabrique = null;
		fabrique = Fabrique.getFabrique(1);
		ObjetConnecte resultat = fabrique.getObjetConnecte(3, 10);
		System.out.println(resultat);
		
	}

}
