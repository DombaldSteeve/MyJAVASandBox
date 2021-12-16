package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Article;

public interface IArticles {
	
	List<Article> extraire() throws SQLException;
	void insert(Article article) throws SQLException;
	int updateRef(Article id, String ref) throws SQLException;
	int updateDesign(Article id, String designation) throws SQLException;
	int updatePrix(Article id, Double prix) throws SQLException;
	int updateIdFou(Article id, int id_fou) throws SQLException;
	boolean delete(Article article) throws SQLException;
	Article fiche(int idfour) throws SQLException;

}
