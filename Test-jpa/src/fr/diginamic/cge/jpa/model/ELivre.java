package fr.diginamic.cge.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
public class ELivre {
	
	@Id
	private Integer id;
	
	@Column(name = "TITRE", length = 255, nullable = false, unique = false)
	private String nom;
	
	@Column(name = "AUTEUR", length = 50, nullable = false, unique = false)
	private String auteur;

	public ELivre() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	
	
	

}
