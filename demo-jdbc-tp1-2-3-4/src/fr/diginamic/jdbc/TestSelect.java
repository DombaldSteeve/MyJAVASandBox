package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import fr.diginamic.jdbc.connection.ConnexionBdD;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect extends Fournisseur {

	public TestSelect(int id, String nom) {
			super(id, nom);
			// TODO Auto-generated constructor stub
		}
	
	public static void main(String[] args) {
		
		
		/*****     TP3 exercice 4     *****/
		
		/*
		try {
			ResourceBundle cont = ResourceBundle.getBundle("database");
			String url = cont.getString("database.url");
			String driver = cont.getString("database.driver");
			String user = cont.getString("database.user");
			String mdp = cont.getString("database.password");
			
			Class.forName(driver);
			Connection connexion = DriverManager.getConnection(url, user, mdp);
			System.out.println("Connexion établie à la base de donnée : " + connexion.getCatalog());
			
			Statement statement = connexion.createStatement();
			ResultSet curseur = statement.executeQuery("SELECT * FROM FOURNISSEUR");
			
			ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
			
			while (curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				
				Fournisseur fournisseurCourant = new Fournisseur(id, nom);
				fournisseurs.add(fournisseurCourant);
				System.out.println(id +" "+ nom);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*****     TP5     *****/
		Connection conn;
		
		try {
			
			
			conn = ConnexionBdD.getConnection();
			System.out.println("Connexion établie à la base de donnée établit ");
			
			Statement statement = conn.prepareStatement("SELECT * FROM FOURNISSEUR");
			ResultSet curseur = statement.executeQuery("SELECT * FROM FOURNISSEUR");
			
			ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
			
			while (curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				
				Fournisseur fournisseurCourant = new Fournisseur(id, nom);
				fournisseurs.add(fournisseurCourant);
				System.out.println(id +" "+ nom);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
