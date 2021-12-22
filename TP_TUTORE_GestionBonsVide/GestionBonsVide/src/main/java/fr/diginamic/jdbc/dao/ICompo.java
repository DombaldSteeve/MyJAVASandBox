package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Compo;

public interface ICompo {
	
	List<Compo> extraire() throws SQLException;
	void insert(Compo compo) throws SQLException;
	boolean delete(Compo compo) throws SQLException;
	Compo fiche(int id) throws SQLException;
	int updateQte(int id, int qte) throws SQLException;

}
