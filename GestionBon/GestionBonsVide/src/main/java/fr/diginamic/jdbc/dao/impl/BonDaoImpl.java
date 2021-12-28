package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnectionBdd;
import fr.diginamic.jdbc.dao.IBon;
import fr.diginamic.jdbc.entites.Bon;

public class BonDaoImpl implements IBon {
	
	private Connection conn;
	private Statement stm;
	
	//CONNEXION avec la BdD pour Articles grace a la classe ConnectionBdd que l'on importe
	public BonDaoImpl() throws SQLException {
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
	public List<Bon> extraire() throws SQLException {
		
	// Requête SQL
			String sql = "SELECT ID, NUMERO, DATE_CMDE, DELAI FROM BON";
			
			List<Bon> listeBon = new ArrayList<>();
			
			try {
				this.stm = this.conn.createStatement();
				
				ResultSet rs = this.stm.executeQuery(sql); // Mise en place du curseur
				
				while (rs.next()) {
					Bon a = new Bon(rs.getInt("ID"), rs.getInt("NUMERO"), rs.getDate("DATE_CMDE"), rs.getInt("DELAI"));
					listeBon.add(a);	
				}
				rs.close();
				return listeBon;
			} finally {
				if(stm != null && !stm.isClosed()) {
					stm.close();
				}
			}
	}

	@Override
	public void insert(Bon bon) throws SQLException {
		// Requête SQL
			String sql = "INSERT INTO BON (NUMERO, DELAI) " + " VALUES ('" + bon.getNumero()
																						+ "', '" + bon.getDelai()
																						+ "')";
			try {
				this.stm = this.conn.createStatement();
				this.stm.executeUpdate(sql);
			} finally {
				if(this.stm != null && !this.stm.isClosed())
					stm.close();
			}
	}
	

	@Override
	public int updateNumero(int id, int numero) throws SQLException {
		// Requête SQL
		String sql = "UPDATE BON SET NUMERO = '" + numero + "' WHERE ID = ? '";
		
		try {
			this.stm = this.conn.createStatement();
			return this.stm.executeUpdate(sql);
		} finally {
			if(this.stm != null && !this.stm.isClosed())
				this.stm.close();
		}
	}

	@Override
	public int updateDate_Cmde(Bon id, Date date_cmde) throws SQLException {
		// Requête SQL
			String sql = "UPDATE BON SET DATE_CMDE = '" + date_cmde + "' WHERE ID = ? '";
			
			try {
				this.stm = this.conn.createStatement();
				return this.stm.executeUpdate(sql);
			} finally {
				if(this.stm != null && !this.stm.isClosed())
					this.stm.close();
			}
	}

	@Override
	public int updateDelai(int id, int delai) throws SQLException {
		// Requête SQL
			String sql = "UPDATE BON SET DELAI = '" + delai + "' WHERE ID = ? '";
			
			try {
				this.stm = this.conn.createStatement();
				return this.stm.executeUpdate(sql);
			} finally {
				if(this.stm != null && !this.stm.isClosed())
					this.stm.close();
			}
	}
	

	@Override
	public int updateIdFou(Bon id, int id_fou) throws SQLException {
		// Requête SQL
			String sql = "UPDATE BON SET ID = '" + id_fou + "' WHERE ID = ? '";
			
			try {
				this.stm = this.conn.createStatement();
				return this.stm.executeUpdate(sql);
			} finally {
				if(this.stm != null && !this.stm.isClosed())
					this.stm.close();
			}
	}


	@Override
	public Bon fiche(int bon) throws SQLException {
		// Requête SQL
			String sql = "SELECT ID, NUMERO, DATE_CMDE, DELAI, ID_FOU fROM BON WHERE NUMERO = " + bon;
			ResultSet rs = null;
			
			try {
				this.stm = this.conn.createStatement();
				rs = this.stm.executeQuery(sql);
				if(rs.next()) {
					return new Bon(rs.getInt("ID"), rs.getInt("NUMERO"), rs.getDate("DATE_CMDE"), rs.getInt("DELAI"));
				}
				return null;
			} finally {
				if(rs != null && !rs.isClosed()) 
					rs.close();
				if(this.stm != null && !this.stm.isClosed())
					this.stm.close();
			}
	}

	@Override
	public boolean delete(Bon bon) throws SQLException {
		String sql = "DELETE FROM BON WHERE NUMERO =" + bon.getId();
				
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


}
