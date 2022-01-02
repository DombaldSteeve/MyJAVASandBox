package fr.diginamic.cge.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "ADRESSE")
public class Adresse {
	
	
	@Column(name = "NUMERO", nullable = true)
	private int numero;
	
	@Column(name = "RUE", nullable = true)
	private String rue;
	
	@Column(name = "CODEPOSTAL", nullable = true)
	private int codePostal;
	
	@Column(name = "VILLE", nullable = true)
	private String ville;
	
	

	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public String getRue() {
		return rue;
	}



	public void setRue(String rue) {
		this.rue = rue;
	}



	public int getCodePostal() {
		return codePostal;
	}



	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public Adresse() {
		// TODO Auto-generated constructor stub
	}

}
