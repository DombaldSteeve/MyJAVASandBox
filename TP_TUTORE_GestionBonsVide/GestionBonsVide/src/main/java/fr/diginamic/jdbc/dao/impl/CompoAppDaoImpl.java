package fr.diginamic.jdbc.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.diginamic.jdbc.dao.ICompoApp;
import fr.diginamic.jdbc.entites.CompoApp;
import fr.diginamic.jdbc.connection.ConnectionBdd;

public class CompoAppDaoImpl implements ICompoApp {
	
	private Connection conn;
	private Statement stm;
	
	//CONNEXION avec la BdD pour Articles grace a la classe ConnectionBdd que l'on importe
		public CompoAppDaoImpl() throws SQLException {
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
	public void insert(CompoApp compoApp) throws SQLException {
		
		PreparedStatement insertDesign = conn.prepareStatement("INSERT INTO ARTICLE (DESIGNATION) VALUES (?)");
		PreparedStatement insertNum = conn.prepareStatement("INSERT INTO BON (NUMERO) VALUES (?)");
		PreparedStatement insertQte = conn.prepareStatement("INSERT INTO COMPO (QTE) VALUES (?)");
		insertDesign.setString(1, compoApp.getDesign());
		insertNum.setInt(1, compoApp.getNum());
		insertQte.setInt(1, compoApp.getQte()); 
		
	}

}
