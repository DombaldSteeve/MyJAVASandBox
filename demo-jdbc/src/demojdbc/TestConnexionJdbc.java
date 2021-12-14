package demojdbc;

import java.sql.*;
import java.util.ResourceBundle;


public class TestConnexionJdbc {
	

	public static void main(String[] args) {
		
		
		try {
			ResourceBundle cont = ResourceBundle.getBundle("database");
			String url = cont.getString("database.url");
			String driver = cont.getString("database.driver");
			String user = cont.getString("database.user");
			String mdp = cont.getString("database.password");
			
			Class.forName(driver);
			Connection connexion = DriverManager.getConnection(url, user, mdp);
			System.out.println("Connexion établie à la base de donnée : " + connexion.getCatalog());
			
			//Class.forName(driver2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
}
