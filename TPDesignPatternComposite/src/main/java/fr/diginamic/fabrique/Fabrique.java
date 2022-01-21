package fr.diginamic.fabrique;

import java.util.Scanner;

import fr.diginamic.composite.FabriqueDepartement;
import fr.diginamic.composite.FabriquePersonne;
import fr.diginamic.composite.IEntite;

public abstract class Fabrique {
	
	public abstract IEntite createEntite();
	
	public static IEntite getFabrique() {
		
		System.out.println("Veuillez taper 1 si vous voulez créer une personne ou 2 pour créer un département :");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if (num == 1) {
			return new FabriquePersonne().createEntite();
		} else if (num == 2) {
			return new FabriqueDepartement().createEntite();
		}
		return null;
		
	}

}
