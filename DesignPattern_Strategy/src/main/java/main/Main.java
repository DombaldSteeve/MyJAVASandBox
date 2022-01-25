package main;

import entites.Calculer;
import entites.CalculerCout;
import entites.CalculerPrix;
import entites.ClassB;
import entites.ClassC;
import entites.Use;

public class Main
{
	public static void main(String[] args)
	{
		Use cas1 = new Use(new ClassC(null));
		cas1.AfficherClass();
		Use cas2 = new Use(new ClassB(null));
		cas2.AfficherClass();
		// exploitation en polymorphisme
		Calculer calcul = new Calculer(new CalculerPrix());
		System.out.println(calcul.Calcul());
		Calculer calcul2 = new Calculer(new CalculerCout());
		System.out.println(calcul2.Calcul());
		Calculer calculerRevient = ((calcul) - (calcul2));
	}
}
