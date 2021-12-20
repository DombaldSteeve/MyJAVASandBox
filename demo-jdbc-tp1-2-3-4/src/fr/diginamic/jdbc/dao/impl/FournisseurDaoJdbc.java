package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdD;
import fr.diginamic.jdbc.dao.IFournisseur;
import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements IFournisseur {

	
	    /*****     TP4     *****/
	
	
	private Connection conn;
	private PreparedStatement stmt;
	

	public FournisseurDaoJdbc() throws SQLException {
		// TODO Auto-generated constructor stub
		this.conn = ConnexionBdD.getConnection();
		if(this.conn == null) throw new SQLException("Connexion inexistante !");
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		if(this.conn != null && !this.conn.isClosed()) this.conn.close();
	}

	@Override
	public List<Fournisseur> extraire() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT ID, NOM FROM FOURNISSEUR;";
		List<Fournisseur> ls = new ArrayList<>();
		try {
			this.stmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.stmt.executeQuery(sql);
			while(rs.next()) {
				Fournisseur f = new Fournisseur(rs.getInt("ID"), rs.getString("NOM"));
				ls.add(f);
			}
			rs.close();
			return ls;
		}finally {
			if(this.stmt != null && !this.stmt.isClosed())  this.stmt.close();
		}
		
	}

	@Override
	/*****     TP 3 - 4 *****/
	/*
	public void insert(Fournisseur fournisseur) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO FOURNISSEUR (NOM) VALUES('" + fournisseur.getNom() + "')";
		try {
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.executeUpdate(sql);
			
		}
		finally {
			if(this.stmt != null && !this.stmt.isClosed())  this.stmt.close();
		}
	}
	*/
	
	/*****     TP5     *****/
	
	public void insert(String fournisseur) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO FOURNISSEUR (NOM) VALUES('" + fournisseur + "')";
		try {
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.executeUpdate(sql);
			
		}
		finally {
			if(this.stmt != null && !this.stmt.isClosed())  this.stmt.close();
		}
	}

	@Override
		/*****     TP 3 / 4 *****/
	/*
	public int update(String ancienNom, String nouveauNom) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE FOURNISSEUR SET NOM = '" + nouveauNom + "' WHERE NOM = '" + ancienNom + "'";
		try {
			this.stmt = this.conn.createStatement();
			return this.stmt.executeUpdate(sql);
			
		}
		finally {
			if(this.stmt != null && !this.stmt.isClosed())  this.stmt.close();
		}
		*/
		
		/*****     TP5     *****/
	
	public int update(String ancienNom, String nouveauNom) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE FOURNISSEUR SET NOM = '" + nouveauNom + "' WHERE NOM = '" + ancienNom + "'";
		try {
			this.stmt = this.conn.prepareStatement(sql);
			return this.stmt.executeUpdate(sql);
			
		}
		finally {
			if(this.stmt != null && !this.stmt.isClosed())  this.stmt.close();
		}
	}
	
	

	@Override
	public boolean delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = ("DELETE FROM FOURNISSEUR WHERE ID = "  + id ) ;
		try {
			this.stmt = this.conn.prepareStatement(sql);
			if( this.stmt.executeUpdate(sql)>0) return true;	
		}
		finally {
			if(this.stmt != null && !this.stmt.isClosed())  this.stmt.close();
		}
		return false;
	}

	@Override
	public Fournisseur fiche(int idfour) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT ID, NOM FROM FOURNISSEUR WHERE ID=" + idfour;
		ResultSet rs = null;
		try {
			this.stmt = this.conn.prepareStatement(sql);
			rs = this.stmt.executeQuery(sql);
			if(rs.next()) {
				return new Fournisseur(rs.getInt("ID"), rs.getString("NOM"));
			}
			return null;
		}finally {
			if(rs != null && !rs.isClosed()) rs.close();
			if(this.stmt != null && !this.stmt.isClosed())  this.stmt.close();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}


