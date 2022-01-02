package fr.diginamic.cge.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BANQUE")
public class EBanque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "ID_CLIENT")
	private EClient idClient;
	
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	
	

	public EBanque() {
		// TODO Auto-generated constructor stub
	}
	

	public EBanque(int id, EClient idClient, String nom) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.nom = nom;
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


	public EClient getIdClient() {
		return idClient;
	}


	public void setIdClient(EClient idClient) {
		this.idClient = idClient;
	}

	

}
