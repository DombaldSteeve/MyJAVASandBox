package fr.diginamic.jdbc.dao.impl;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDao extends Fournisseur {
	
	int id;
	String nom;

	public FournisseurDao() {
		// TODO Auto-generated constructor stub
	}
	
	public FournisseurDao(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

}
