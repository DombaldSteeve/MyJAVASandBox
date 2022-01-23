package fr.diginamic.composite;

import java.util.Scanner;

import fr.diginamic.fabrique.Fabrique;

public class FabriquePersonne extends Fabrique {
	
	

	@Override
	public IEntite createEntite(int Id) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Donner un nom à votre personne :");
		String nomPers = scan.next();
		
		System.out.println("Donner un prénom à votre personne :");
		String prenomPers = scan.next();
		
		return new Personne(nomPers, prenomPers);
	}

}
