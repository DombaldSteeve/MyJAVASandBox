package Test;

import java.io.BufferedReader;
import java.io.FileReader;

import Patterns.Classe;
import Patterns.Fabrique;

public class TestFabriqueAbstraite {
	

	public static void main(String[] args) {
		Fabrique fabrique = null;
		Classe obj = null;
			try 
			{
				BufferedReader fichier = new BufferedReader(new FileReader("version"));
				String nomClasse = fichier.readLine();
				fabrique = (Fabrique) Class.forName(nomClasse).newInstance();
				obj = fabrique.creerClasse();
				System.out.println("obj.getType() : " + obj.getType());
			}
			catch(Exception e) 
			{
			System.out.println("Exception : " + e.getMessage());
			}
	}
}
