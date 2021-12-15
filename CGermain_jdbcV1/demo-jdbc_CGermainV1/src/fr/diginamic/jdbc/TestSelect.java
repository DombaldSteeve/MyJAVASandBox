package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;
import proj01.main.connexion.ConnectionBdd;

public class TestSelect {
	private Connection con;
	private Statement stm;

	/**
	 * Dans el constructeur on établit tout de suite la connexion
	 * @throws Exception
	 */
	public TestSelect() throws Exception {
		// TODO Auto-generated constructor stub
		con = ConnectionBdd.getConnection();
		if(con == null) throw new SQLException("Connexion inexstante !"); 
	}

	/**
	 * Destructeur et fermeture automatique de la connexion à la BDD
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		if(this.con != null) this.con.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TestSelect ti = new TestSelect();
			ti.extraire().stream().forEach(f -> System.out.println(f.getNom()));;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public List<Fournisseur> extraire() throws SQLException {
		String sql = "SELECT ID,NOM FROM FOURNISSEUR"; 
		List<Fournisseur> lf = new ArrayList<>();
		
		try {
			this.stm = this.con.createStatement();
			ResultSet rs =  this.stm.executeQuery(sql);
			while(rs.next()) {
				Fournisseur f = new Fournisseur(rs.getInt("id"),rs.getString("NOM"));
				lf.add(f);
			}
			return lf;
		}
		finally {
			if(this.stm != null && !this.stm.isClosed()) {
				this.stm.close();
			}
			
		}
	}

}
