package fr.diginamic.main;

import java.util.Scanner;

import fr.diginamic.composite.IEntite;
import fr.diginamic.fabrique.Fabrique;

public class Main
{
	public static void main(String[] args)
	{
		Fabrique.getEntity(2);
		boolean end = false;
		while (!end) {
			System.out.println();
			System.out.print("[1] - Créer une personne         - \n" + "[2] - Créer un département       - \n"
					+ "[3] - Afficher toutes les entités     -\n" + "[4] - Quitter le programme       - \n"
					+ "Taper votre choix --->");
			System.out.println();
			Scanner scan = new Scanner(System.in);
			int choix = scan.nextInt();
			switch(choix)
			{
			case 1:
				IEntite personne = Fabrique.getEntity(choix);
				Fabrique.addToDepartement(personne);
				break;
			case 2:
				IEntite sousDep = Fabrique.getEntity(choix);
				Fabrique.addToDepartement(sousDep);
				break;
			case 3:
				Fabrique.findDepartement(1).execute();
				break;
			case 4:
				System.out.println("Fin du programme");
				end = true;
				break;
			}
		}
	}
}
