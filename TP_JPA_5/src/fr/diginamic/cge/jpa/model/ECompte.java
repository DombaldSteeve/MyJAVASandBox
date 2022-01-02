package fr.diginamic.cge.jpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class ECompte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NUMERO", length = 75, nullable = true)
	private String numero;
	
	@Column(name = "SOLDE" , length = 75, nullable = true)
	private Double solde;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private EClient idclient;
	
	@OneToOne
	@JoinColumn(name = "ID_OPERATION")
	private EOperation idoperation;

	
	public ECompte() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ECompte(int id, String numero, Double solde, EClient idclient, EOperation idoperation) {
		super();
		this.id = id;
		this.numero = numero;
		this.solde = solde;
		this.idclient = idclient;
		this.idoperation = idoperation;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public EClient getIdclient() {
		return idclient;
	}

	public void setIdclient(EClient idclient) {
		this.idclient = idclient;
	}



	public EOperation getIdoperation() {
		return idoperation;
	}



	public void setIdoperation(EOperation idoperation) {
		this.idoperation = idoperation;
	}

	

}
