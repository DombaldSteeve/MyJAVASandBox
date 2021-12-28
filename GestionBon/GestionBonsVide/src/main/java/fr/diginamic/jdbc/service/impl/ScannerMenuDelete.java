package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;

public class ScannerMenuDelete extends ScannerMenu {

	public ScannerMenuDelete() {
		// TODO Auto-generated constructor stub
	}
	
	public static void scannerMenuDeleteFour(int param) throws SQLException {
		
		FournisseurDaoImpl f = new FournisseurDaoImpl();
		Fournisseur four = new Fournisseur();
		four.setId(param);
		f.delete(four);
	}
	
	public static void scannerMenuDeleteArt(int param) throws SQLException {
		
		ArticleDaoImpl a = new ArticleDaoImpl();
		Article art = new Article();
		art.setId(param);
		a.delete(art);
	}
	
	public static void scannerMenuDeleteBon(int param) throws SQLException {
		
		BonDaoImpl b = new BonDaoImpl();
		Bon bon = new Bon();
		bon.setId(param);
		b.delete(bon);
	}
	

}
