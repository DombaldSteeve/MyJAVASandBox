package Applications;


import java.util.ArrayList;
import java.util.List;

import Classes.Avion;
import Classes.CompteCourant;
import Classes.Hydravion;
import Classes.Voilier;
import Interfaces.iOperation;

public class Application {
	
	public Application() {
		
	}
	
	public static void main(String[] args) {
		
		Voilier v = new Voilier();
		System.out.println("Je suis un voilier !");
		v.coule();
		v.flotte();
		
		System.out.println();
		
		Hydravion h = new Hydravion();
		System.out.println("Je suis un hydravion !");
		h.vole();
		h.atterrir();
		
		System.out.println();
		
		Avion av = new Avion();
		System.out.println("Je suis un avion !");
		av.atterrir();
		
		System.out.println();
		
		
		/*****     Expressions Lambda     *****/
		
		iOperation addition = (a, b) -> a + b;
		iOperation soustraction = (a, b) -> a - b;
		iOperation multiplication = (a, b) -> a * b;
		iOperation division = (a, b) -> {
			Double div = 0.0;
			if (b == 0 ) return div;
			div = a/b;
			return div;
		};
		
		
		List<iOperation> lop = new ArrayList<iOperation>();
		lop.add(division);
		lop.add(addition);
		lop.add(multiplication);
		lop.add(soustraction);
		
		lop.forEach(op -> System.out.println(op.calcul(12.6, 23.7)));
		
		try {
			System.out.println(addition.calcul(12.6, 23.7));
			System.out.println(soustraction.calcul(98.6, 55.3));
			System.out.println(multiplication.calcul(2.3, 15.9));
			System.out.println(division.calcul(458.3, 4.0));
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println();
		
		
		List<CompteCourant> listeCompte = new ArrayList<CompteCourant>();
		
		
		listeCompte.add(new CompteCourant());
		listeCompte.add(new CompteCourant(25023.36));
		listeCompte.add(new CompteCourant(-200.36));
		listeCompte.add(new CompteCourant(299.36));
		listeCompte.add(new CompteCourant(-20.36));
		
		
		/**
		 * Renvoi moi le solde des comptes positifs
		 * grace à .get
		 */
		System.out.println("Solde des comptes supérieurs à 0: " +
				listeCompte.stream()
				.map(t -> t.getSolde())
				.filter(t -> t>0)
				.reduce((t1, t2) -> t1 + t2).get());
		/**
		 * Renvoi moi le nombre de compte bancaire postifs
		 * grace à .count
		 */
		System.out.println("Nombre de compte en positifs : " +
				listeCompte.stream()
				.map(t -> t.getSolde())
				.filter(t -> t > 0).count());
		/**
		 * Renvoi la moyenne des soldes en positifs
		 * grace à .average
		 */
		System.out.println("Moyenne des cpt > 0 : "+
				listeCompte.stream()
					.mapToDouble(t->t.getSolde())
					.filter(t->t>0)
					.average().getAsDouble());
		
	}

}
