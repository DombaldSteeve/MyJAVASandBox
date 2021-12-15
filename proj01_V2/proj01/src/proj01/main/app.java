package proj01.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import proj01.main.connexion.ConnectionBdd;

public class app {

	public app() {
		// TODO Auto-generated constructor stub
	}
/*
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
			
			Class.forName(driver);
	        Connection connection = 
	       		 DriverManager.getConnection(url,user,mtp);
	        System.out.println("Connection réussie à la Base : " + connection.getCatalog());

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
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conx1=null;
		Connection conx2=null;
		try {
			conx1 = ConnectionBdd.getConnection();
			conx2 = ConnectionBdd.getConnection("database2");
			
			if(conx1!=null) {
				System.out.println("Base "+conx1.getCatalog()+" connectée !");
			}
			if(conx2!=null) {
				System.out.println("Base "+conx2.getCatalog()+" connectée !");
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
		 if(conx1 != null)
			try {
				conx1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		 if(conx2 != null)
			try {
				conx2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
