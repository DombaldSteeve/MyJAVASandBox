package fr.diginamic.jdbc;

import java.sql.*;

import fr.diginamic.jdbc.connection.ConnexionBdD;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestInsertion {
	
	
	public static void main(String[] args) {
		
		/*****     TP3      *****/
		
			/*****     Exercice 1     *****/
		/*
		try {
			FournisseurDaoJdbc fdi = new FournisseurDaoJdbc();
			// Créer
			fdi.insert(new Fournisseur(0,"La Maison de la Peinture"));
			fdi.extraire().stream().forEach(fo->System.out.println(fo.getNom()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*****     TP5     *****/
		
		try {
			FournisseurDaoJdbc fdi = new FournisseurDaoJdbc();
			fdi.insert("Levrault");
			fdi.extraire().stream().forEach(fo->System.out.println(fo.getNom()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
		
	
}

}
