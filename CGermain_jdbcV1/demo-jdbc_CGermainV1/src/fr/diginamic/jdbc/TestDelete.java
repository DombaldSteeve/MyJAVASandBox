package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import proj01.main.connexion.ConnectionBdd;

public class TestDelete {
	private Connection con;
	private Statement stm;

	/**
	 * Dans el constructeur on établit tout de suite la connexion
	 * @throws Exception
	 */
	public TestDelete() throws Exception {
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
			TestDelete ti = new TestDelete();
			ti.delete("La Maison des Peintures");
			ti.extraire();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int delete(String nom) throws SQLException {
		String sql = "Delete From  FOURNISSEUR where nom = '"+nom +"';"; 
		try {
			this.stm = this.con.createStatement();
			return this.stm.executeUpdate(sql);
		}
		finally {
			if(this.stm != null && !this.stm.isClosed()) {
				this.stm.close();
			}
			
		}
	}

	public void extraire() throws SQLException {
		String sql = "SELECT ID,NOM FROM FOURNISSEUR"; 
		try {
			this.stm = this.con.createStatement();
			ResultSet rs =  this.stm.executeQuery(sql);
			System.out.println("Liste des Fournisseurs");
			while(rs.next()) {
				System.out.println("Id : "+ rs.getInt("id")+
						" - Nom : "+rs.getString("nom"));
			}
			System.out.println("---------------------------");
		}
		finally {
			if(this.stm != null && !this.stm.isClosed()) {
				this.stm.close();
			}
			
		}
	}

}
