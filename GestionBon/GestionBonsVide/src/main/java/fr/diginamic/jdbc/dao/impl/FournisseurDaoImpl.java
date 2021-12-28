package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import fr.diginamic.jdbc.connection.ConnectionBdd;
import fr.diginamic.jdbc.dao.IFournisseurDao;
import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoImpl  implements IFournisseurDao  {
	
	private Connection conn;
	private Statement stmt;
	

	public FournisseurDaoImpl() throws SQLException {
		// TODO Auto-generated constructor stub
		this.conn = ConnectionBdd.getConnection();
		if(this.conn == null) throw new SQLException("Connexion inexistante !");
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		if(this.conn != null && !this.conn.isClosed()) this.conn.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Fournisseur> extraire() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT ID, NOM FROM FOURNISSEUR;";
		List<Fournisseur> ls = new ArrayList<>();
		try {
			this.stmt = this.conn.createStatement();
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
	public void insert(Fournisseur fournisseur) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO FOURNISSEUR (NOM) VALUES('" + fournisseur.getNom() + "')";
		try {
			this.stmt = this.conn.createStatement();
			this.stmt.executeUpdate(sql);
			
		}
		finally {
			if(this.stmt != null && !this.stmt.isClosed())  this.stmt.close();
		}
		
	}

	@Override
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
		
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM FOURNISSEUR WHERE ID=" + fournisseur.getId();
		try {
			this.stmt = this.conn.createStatement();
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
		String sql = "SELECT ID, NOM FROM FOURNISSEUR WHERE ID = " + idfour;
		ResultSet rs = null;
		try {
			this.stmt = this.conn.createStatement();
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
	
	
}
