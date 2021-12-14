package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

	public static void main(String[] args) {
		
		try {
			ResourceBundle insertion = ResourceBundle.getBundle("database");
			String url = insertion.getString("database.url");
			String driver = insertion.getString("database.driver");
			String user = insertion.getString("database.user");
			String mdp = insertion.getString("database.password");
			
			Class.forName(driver);
			Connection connexion = DriverManager.getConnection(url, user, mdp);
			System.out.println("Connexion �tablie � la BdD nomm� : " + connexion.getCatalog());
			
			Statement statement = connexion.createStatement();
			@SuppressWarnings("unused")
			int nb = statement.executeUpdate("DELETE FROM FOURNISSEUR WHERE NOM = 'La Maison Des Peintures'");
			System.out.println("Suppression r�ussite dans la base de donn�e " + connexion.getCatalog());
			
		} catch (Exception e) {
			System.out.println("Insertion / Connexion failed");
			e.printStackTrace();
		}


	}

}
