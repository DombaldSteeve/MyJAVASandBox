package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Article;

public interface IArticles {
	
	List<Article> extraire() throws SQLException;
	void insert(Article article) throws SQLException;
	int updateRef(int id, String ref) throws SQLException;
	int updateDesign(int id, String designation) throws SQLException;
	int updatePrix(int id, Double prix) throws SQLException;
	int updateIdFou(int id, int id_fou) throws SQLException;
	boolean delete(Article article) throws SQLException;
	Article fiche(int idfour) throws SQLException;

}
