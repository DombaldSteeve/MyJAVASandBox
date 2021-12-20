package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public interface IFournisseur {
	
	List<Fournisseur> extraire() throws SQLException;
	void insert(Fournisseur fournisseur) throws SQLException;
	int update(String ancienNom , String nouveauNom) throws SQLException;
	boolean delete(Fournisseur fournisseur) throws SQLException;
	Fournisseur fiche(int idfour) throws SQLException;
	boolean delete(int id) throws SQLException;
	void insert(String fournisseur) throws SQLException;

}


