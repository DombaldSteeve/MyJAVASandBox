package MainPack;

import ObjetsClass.Fabrique;
import ObjetsClass.ObjetConnecte;

public class App {
	
	public static void main(String[] args) {
		
		Fabrique fabrique = null;
		fabrique = Fabrique.getFabrique(3);
		ObjetConnecte resultat = fabrique.getObjetConnecte(1, 3);
		System.out.println(resultat);
		
	}

}
