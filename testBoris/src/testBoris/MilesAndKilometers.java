package testBoris;

import java.util.Locale;
import java.util.Scanner;

public class MilesAndKilometers {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.US);
		
		double miles;
		System.out.print("Valeur en Miles ? ");
		miles = input.nextDouble();
		
		double convertisseurKm;
		convertisseurKm = (miles*1.609);
		
		double kilometers = miles + convertisseurKm;
		System.out.println("Pour " + miles + " Miles ," + " la valeur en kilomètres est de " + kilometers + " Km ");
	}

}
