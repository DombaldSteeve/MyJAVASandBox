package fr.diginamic.jdbc.service.impl;

import java.util.Scanner;

public class ScannerLauncher {
	
	public String userEntry;
	
	
	public static String getUserInput() {
		
		Scanner ScanLaunch = new Scanner(System.in);
		System.out.println();
		System.out.println("Veuillez taper vote saisie: ");
		String userEntry = ScanLaunch.nextLine();
		return userEntry;
		
				
	}

}
