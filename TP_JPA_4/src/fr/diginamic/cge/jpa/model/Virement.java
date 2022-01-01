package fr.diginamic.cge.jpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("1")
public class Virement extends EOperation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String beneficiaire;
	

	public Virement() {
		// TODO Auto-generated constructor stub
	}


	public Virement(int id, String beneficiaire) {
		super();
		this.id = id;
		this.beneficiaire = beneficiaire;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBeneficiaire() {
		return beneficiaire;
	}


	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
	

}
