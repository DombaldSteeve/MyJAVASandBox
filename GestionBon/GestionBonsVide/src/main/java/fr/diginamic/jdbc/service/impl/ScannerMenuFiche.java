package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;

public class ScannerMenuFiche extends ScannerMenu {

	public ScannerMenuFiche() {
		// TODO Auto-generated constructor stub
	}

	public static Fournisseur scannerMenuFicheFour(int afficheFour) throws SQLException {
		
		
			FournisseurDaoImpl f = new FournisseurDaoImpl();
			return f.fiche(afficheFour);
		
	}
	
	public static Article scannerMenuFicheArt(int afficheArt) throws SQLException {
		
		
		ArticleDaoImpl a = new ArticleDaoImpl();
		return a.fiche(afficheArt);
	
	}
	
	public static Bon scannerMenuFicheBon(int afficheBon) throws SQLException {
		
		
		BonDaoImpl a = new BonDaoImpl();
		return a.fiche(afficheBon);
	
	}
	

}
