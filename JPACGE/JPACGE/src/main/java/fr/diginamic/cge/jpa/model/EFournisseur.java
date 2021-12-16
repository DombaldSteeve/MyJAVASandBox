package fr.diginamic.cge.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fournisseur")
public class EFournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // configuration clé primaire elle même en auto incremente dans la BdD
	private int id;
	
	@Column(name = "NOM", length = 25, unique = true)
	private String nom;

	public EFournisseur() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
