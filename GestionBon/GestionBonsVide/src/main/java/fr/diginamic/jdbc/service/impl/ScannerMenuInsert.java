package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.CompoAppDaoImpl;
import fr.diginamic.jdbc.dao.impl.CompoDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Compo;
import fr.diginamic.jdbc.entites.CompoApp;
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
	
	public static void scannerMenuInsertBon(int inputInsertNum, int inputInsertDelai) throws SQLException {
		
		
		BonDaoImpl a = new BonDaoImpl();
		a.insert(new Bon(0, inputInsertNum, null, inputInsertDelai));
	
	}
	
	public static void scannerMenuInsertCompoApp(String inputInsertDesign, int inputInsertNum, int inputInsertQte) throws SQLException {
		
		
		CompoAppDaoImpl c = new CompoAppDaoImpl();
		c.insert(new CompoApp(inputInsertDesign, inputInsertNum, inputInsertQte));
	
	}
	

}
