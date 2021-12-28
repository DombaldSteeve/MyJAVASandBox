package fr.diginamic.jdbc.service.impl;

import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Article;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.IArticles;
import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;



public class ScannerMenuUpdate {
	
	

	public static void scannerMenuUpdateFournisseur(String ancienNom, String nouveauNom) throws SQLException {
		String nameOld = ancienNom;
		String nameNew = nouveauNom;
		FournisseurDaoImpl fournisseurUpdate = new FournisseurDaoImpl();
		fournisseurUpdate.update(nameOld, nameNew);
	}
	
	
	public static void scannerMenuUpdateArticleRef(int id, String nouvelleRef) throws SQLException {
		
		ArticleDaoImpl articleUpdateRef = new ArticleDaoImpl();
		articleUpdateRef.updateRef(id, nouvelleRef);
	}
	public static void scannerMenuUpdateArticleDesign(int id, String designation) throws SQLException {
		
		ArticleDaoImpl articleUpdateDesign = new ArticleDaoImpl();
		articleUpdateDesign.updateDesign(id, designation);
	}
	public static void scannerMenuUpdateArticlePrix(int id, Double prix) throws SQLException {
		
		ArticleDaoImpl articleUpdateDesign = new ArticleDaoImpl();
		articleUpdateDesign.updatePrix(id, prix);
	}
	public static void scannerMenuUpdateArticleIdfou(int id, int idfou) throws SQLException {
		
		ArticleDaoImpl articleUpdateDesign = new ArticleDaoImpl();
		articleUpdateDesign.updateIdFou(id, idfou);
	}
	
	
	public static void scannerMenuUpdateBonNum(int id, int numéro) throws SQLException {
		
		BonDaoImpl bonUpdateDesign = new BonDaoImpl();
		bonUpdateDesign.updateNumero(id, numéro);
	}
	public static void scannerMenuUpdateBonDelai(int id, int delai) throws SQLException {
		
		BonDaoImpl bonUpdateDesign = new BonDaoImpl();
		bonUpdateDesign.updateDelai(id, delai);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
