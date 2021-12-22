package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;

public class ScannerMenuExtraire extends ScannerMenu {

	public static List<Fournisseur> scannerMenuExtraireFour() throws SQLException {
		
		FournisseurDaoImpl listeFour = new FournisseurDaoImpl();
		return listeFour.extraire();
		
	}
	
	public static List<Article> scannerMenuExtraireArt() throws SQLException {
		
		ArticleDaoImpl listeArt = new ArticleDaoImpl();
		return listeArt.extraire();
		
	}
	
	public static List<Bon> scannerMenuExtraireBon() throws SQLException {
		
		BonDaoImpl listeBon = new BonDaoImpl();
		return listeBon.extraire();
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
