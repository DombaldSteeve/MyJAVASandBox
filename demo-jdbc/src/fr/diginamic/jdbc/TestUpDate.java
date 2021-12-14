package fr.diginamic.jdbc;

import java.sql.*;
import java.util.ResourceBundle;


public class TestUpDate {
	
public static void main(String[] args) {
		
		try {
			ResourceBundle insertion = ResourceBundle.getBundle("database");
			String url = insertion.getString("database.url");
			String driver = insertion.getString("database.driver");
			String user = insertion.getString("database.user");
			String mdp = insertion.getString("database.password");
			
			Class.forName(driver);
			Connection connexion = DriverManager.getConnection(url, user, mdp);
			System.out.println("Connexion établie à la BdD nommé : " + connexion.getCatalog());
			
			Statement statement = connexion.createStatement();
			@SuppressWarnings("unused")
			int nb = statement.executeUpdate("UPDATE FOURNISSEUR SET NOM = 'Dubois & Fils' WHERE ID = 3");
			System.out.println("Insertion réussite dans la base de donnée : " + connexion.getCatalog());
			
		} catch (Exception e) {
			System.out.println("Insertion / Connexion failed");
			e.printStackTrace();
		}

	}
}
