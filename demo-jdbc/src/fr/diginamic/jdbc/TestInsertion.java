package fr.diginamic.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class TestInsertion {

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
			int nb = statement.executeUpdate("INSERT INTO FOURNISSEUR(ID, NOM) VALUES(1,'Francaise d'Imports')");
			System.out.println("Insertion réussite dans la base de donnée : " + connexion.getCatalog());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
