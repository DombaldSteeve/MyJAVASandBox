package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.dao.impl.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDelete {

	public static void main(String[] args) {
		
		/*****     Exercice 3     *****/
	
		/*
		try {
			FournisseurDaoJdbc fdi = new FournisseurDaoJdbc();
			// Supprimer
			fdi.delete(new Fournisseur(18, "La Maison Des Peintures"));
			fdi.extraire().stream().forEach(fo->System.out.println(fo.getNom()));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*****     TP5     *****/
		
		try {
			FournisseurDaoJdbc fdi = new FournisseurDaoJdbc();
			fdi.delete(16);
			fdi.extraire().stream().forEach(fo->System.out.println(fo.getNom()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


	}

}
