package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;

public class ScannerMenuInsert extends ScannerMenu{
	
	public static void scannerMenuInsertFour(String inputInsert) throws SQLException {
		
		FournisseurDaoImpl f = new FournisseurDaoImpl();
		f.insert(new Fournisseur(0, inputInsert));
	}	
	
	public static void scannerMenuInsertArt(String inputInsertRef, String inputInsertDesign, Double inputInsertPrix, int inputInsertIdfou) throws SQLException {
		
		
		ArticleDaoImpl a = new ArticleDaoImpl();
		a.insert(new Article(0, inputInsertRef, inputInsertDesign, inputInsertPrix, inputInsertIdfou));
	
	}
	

}
