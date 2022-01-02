package fr.diginamic.cge.jpa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class EClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ID_BANQUE")
	private EBanque idBanque;
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private ECompte idcompte;
	
	@Embedded
	private Adresse adresse;

	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;
	
	@Column(name = "DATENAISSANCE", length = 10, nullable = true)
	private LocalDate dateNaissance;
	 
	

	public EClient(int id, EBanque idBanque, ECompte idcompte, Adresse adresse, String nom, String prenom,
			LocalDate dateNaissance) {
		super();
		this.id = id;
		this.idBanque = idBanque;
		this.idcompte = idcompte;
		this.adresse = adresse;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	public EClient() {}

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public EBanque getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(EBanque idBanque) {
		this.idBanque = idBanque;
	}

	public ECompte getIdcompte() {
		return idcompte;
	}

	public void setIdcompte(ECompte idcompte) {
		this.idcompte = idcompte;
	}
	

}
