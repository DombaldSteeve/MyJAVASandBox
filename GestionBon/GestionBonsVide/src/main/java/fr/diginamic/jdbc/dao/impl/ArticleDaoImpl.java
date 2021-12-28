package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnectionBdd;
import fr.diginamic.jdbc.dao.IArticles;
import fr.diginamic.jdbc.entites.Article;

public class ArticleDaoImpl implements IArticles {
	
	private Connection conn;
	private Statement stm;
	
	//CONNEXION avec la BdD pour Articles grace a la classe ConnectionBdd que l'on importe
	public ArticleDaoImpl() throws SQLException {
		conn = ConnectionBdd.getConnection();
		if (conn == null) throw new SQLException("Connexion inexistante");
	}
	
	//DECONNEXION on crée un finalize avec final + CtrlEspace et on l'implé
	@Override
	protected void finalize() throws Throwable {
		if(conn != null)
			conn.close();
	}

	@Override
	public List<Article> extraire() throws SQLException {
		
		// Requête SQL
		String sql = "SELECT ID, REF, DESIGNATION, PRIX, ID_FOU FROM ARTICLE";
		
		List<Article> listeArticle = new ArrayList<>();
		
		try {
			this.stm = this.conn.createStatement();
			
			ResultSet rs = this.stm.executeQuery(sql); // Mise en place du curseur
			
			while (rs.next()) {
				Article a = new Article(rs.getInt("ID"), rs.getString("REF"), rs.getString("DESIGNATION"), rs.getDouble("PRIX"), rs.getInt("ID_FOU"));
				listeArticle.add(a);	
			}
			rs.close();
			return listeArticle;
		} finally {
			if(stm != null && !stm.isClosed()) {
				stm.close();
			}
		}
	
	}

	@Override
	public void insert(Article article) throws SQLException {
		// Requête SQL
		String sql = "INSERT INTO ARTICLE (REF, DESIGNATION, PRIX, ID_FOU) " + " VALUES ('" + article.getRef() 
																					+ "', '" + article.getDesignation() 
																					+ "', '" + article.getPrix()
																					+ "', '" + article.getId_fou() + "')";
		try {
			this.stm = this.conn.createStatement();
			this.stm.executeUpdate(sql);
		} finally {
			if(this.stm != null && !this.stm.isClosed())
				stm.close();
		}
	}

	@Override
	public int updateRef(int id, String ref) throws SQLException {
		//Requête SQL
		String sql = "UPDATE ARTICLE SET REF = '" + ref + "' WHERE ID = " + id;
		System.out.println(sql);
		try {
			this.stm = this.conn.createStatement();
			return this.stm.executeUpdate(sql);
		} finally {
			if(this.stm != null && !this.stm.isClosed())
				this.stm.close();
		}
	}

	@Override
	public int updateDesign(int id, String designation) throws SQLException {
		//Requête SQL
		String sql = "UPDATE ARTICLE SET DESIGNATION=  '" + designation + "' WHERE ID = " + id;
		
		try {
			this.stm = this.conn.createStatement();
			return this.stm.executeUpdate(sql);
		} finally {
			if(this.stm != null && !this.stm.isClosed())
				this.stm.close();
		}
	}

	@Override
	public int updatePrix(int id, Double prix) throws SQLException {
		//Requête SQL
		String sql = "UPDATE ARTICLE SET PRIX=  '" + prix + "' WHERE ID = " + id;
		
		try {
			this.stm = this.conn.createStatement();
			return this.stm.executeUpdate(sql);
		} finally {
			if(this.stm != null && !this.stm.isClosed())
				this.stm.close();
		}
	}

	@Override
	public int updateIdFou(int id, int id_fou) throws SQLException {
		//Requête SQL
		String sql = "UPDATE ARTICLE SET ID_FOU=  '" + id_fou + "' WHERE ID = " + id;
		
		try {
			this.stm = this.conn.createStatement();
			return this.stm.executeUpdate(sql);
		} finally {
			if(this.stm != null && !this.stm.isClosed())
				this.stm.close();
		}
	}
	
	@Override
	public boolean delete(Article article) throws SQLException {

		String sql = "DELETE FROM ARTICLE WHERE ID =" + article.getId();
		
		try {
			this.stm = this.conn.createStatement();
			if(this.stm.executeUpdate(sql) > 0)
				return true;
		} finally {
			if(this.stm != null && !this.stm.isClosed())
				this.stm.close();
		}
		return false;
	}

	@Override
	public Article fiche(int article) throws SQLException {

		// Requête SQL
		String sql = "SELECT ID, REF, DESIGNATION, PRIX, ID_FOU FROM ARTICLE WHERE ID = " + article;
		ResultSet rs = null;
		
		try {
			this.stm = this.conn.createStatement();
			rs = this.stm.executeQuery(sql);
			if(rs.next()) {
				return new Article(rs.getInt("ID"), rs.getString("REF"), rs.getString("DESIGNATION"), rs.getDouble("PRIX"), rs.getInt("ID_FOU"));
			}
			return null;
		} finally {
			if(rs != null && !rs.isClosed()) 
				rs.close();
			if(this.stm != null && !this.stm.isClosed())
				this.stm.close();
		}
	}

}


