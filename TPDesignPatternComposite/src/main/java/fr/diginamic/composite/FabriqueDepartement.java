package fr.diginamic.composite;

import java.util.Scanner;

import fr.diginamic.fabrique.Fabrique;

public class FabriqueDepartement extends Fabrique {
	
	

	@Override
	public IEntite createEntite() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Donner un nom � votre d�partement :");
		String nomDep = scan.next();
		
		return new Departement(nomDep);
	}

}
