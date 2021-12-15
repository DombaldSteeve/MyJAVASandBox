package proj01.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class app {

	public app() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ResourceBundle cont = ResourceBundle.getBundle("database");
			String url = cont.getString("database.url");
			String url2 = cont.getString("database.url2");
			String driver = cont.getString("database.driver");
			String driver2 = cont.getString("database.driver2");
			String user = cont.getString("database.user");
			String mtp = cont.getString("database.password");
			String user2 = cont.getString("database.user2");
			String mtp2 = cont.getString("database.password2");
			/**
			 * Une première connexion à une BDD
			 */
			Class.forName(driver);
	        Connection connection = 
	       		 DriverManager.getConnection(url,user,mtp);
	        System.out.println("Connection réussie à la Base : " + connection.getCatalog());
	        /**
			 * Une seconde connexion à une BDD2
			 */
	        Class.forName(driver2);
	        Connection connection2 = 
		       		 DriverManager.getConnection(url2,user,mtp);
		        System.out.println("Connection réussie à la Base 2 : " + connection2.getCatalog());
	        
		}
		catch(SQLException ex) {
			System.err.println("Erreur SQL : "+ex.getMessage());
		}
		catch(Exception ex) {
			System.err.println("Autres erreurs  : "+ex.getMessage());
		}
	}
}
