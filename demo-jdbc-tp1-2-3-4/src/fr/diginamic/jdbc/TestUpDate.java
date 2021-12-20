package fr.diginamic.jdbc;

import java.sql.*;

import fr.diginamic.jdbc.connection.ConnexionBdD;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoJdbc;


public class TestUpDate {
	
	public static void main(String[] args) {
			
		/*****     Exercice 2     *****/
		
		/*
		try {
			FournisseurDaoJdbc fdi = new FournisseurDaoJdbc();
			// Modifier
			fdi.update("La Maison de la Peinture", "La Maison des Peintures");
			fdi.extraire().stream().forEach(fo->System.out.println(fo.getNom()));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		/*****     TP5     *****/
		
		try {
			FournisseurDaoJdbc fdi = new FournisseurDaoJdbc();
			fdi.update("FOURNISSEUR LIE 2", "Bureau Vallée");
			fdi.extraire().stream().forEach(fo->System.out.println(fo.getNom()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}
}


