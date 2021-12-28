package fr.diginamic.jdbc.dao.impl;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnectionBdd;
import fr.diginamic.jdbc.dao.ICompo;
import fr.diginamic.jdbc.entites.Compo;

public class CompoDaoImpl implements ICompo {
	
	private Connection conn;
	private Statement stm;
	
	//CONNEXION avec la BdD pour Articles grace a la classe ConnectionBdd que l'on importe
	public CompoDaoImpl() throws SQLException {
		conn = ConnectionBdd.getConnection();
		if (conn == null) throw new SQLException("Connexion inexistante");
	}
	
	//DECONNEXION on crée un finalize avec final + CtrlEspace et on l'implé
	@Override
	protected void finalize() throws Throwable {
		if(conn != null)
			conn.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Compo> extraire() throws SQLException {
					
			List<Compo> listCompo = new ArrayList<>();
			PreparedStatement extraire = conn.prepareStatement("SELECT ID, ID_ART, ID_BON, QTE FROM COMPO");
			Array array = conn.createArrayOf("INT", listCompo.toArray());
			extraire.setArray(1, array);
			ResultSet rs = extraire.executeQuery();
			return listCompo;
	}

	@Override
	public void insert(Compo compo) throws SQLException {
		PreparedStatement insert = conn.prepareStatement("INSERT INTO COMPO (QTE, ID_ART, ID_BON)  VALUES (?, ?, ?)");
			insert.setInt(1, compo.getQte());
			insert.setInt(2, compo.getId_art());
			insert.setInt(3, compo.getId_bon());
			insert.executeUpdate();
	}

	@Override
	public int updateQte(int id, int qte) throws SQLException {
		PreparedStatement updateQte = conn.prepareStatement("UPDATE COMPO SET QTE = ? WHERE ID = ?");
				updateQte.setInt(1,qte);
				updateQte.setInt(2,id);
				return updateQte.executeUpdate();
	}

	@Override
	public boolean delete(Compo compo) throws SQLException {
		PreparedStatement delete = conn.prepareStatement("DELETE FROM COMPO WHERE ID = ?");
		delete.setInt(compo.getId(), compo.getId());
		return false;
	}

	@Override
	public Compo fiche(int id) throws SQLException {
		
		PreparedStatement fiche = conn.prepareStatement("SELECT ID, NUMERO, DATE_CMDE, DELAI, ID_FOU fROM BON WHERE ID = ?");
		fiche.setInt(1, id);
		ResultSet rs = fiche.executeQuery();
		return (Compo) rs;
	}
}
