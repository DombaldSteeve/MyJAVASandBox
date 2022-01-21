package fr.diginamic.main;

import fr.diginamic.fabrique.Fabrique;
import fr.diginamic.composite.IEntite;

public class Main {
	
	public static void main(String[] args) {
		
		IEntite ent1 = Fabrique.getFabrique();
		
		System.out.println(ent1);
		
		
		
	}
	
}
