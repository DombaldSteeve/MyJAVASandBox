package fr.diginamic.cge.jpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class EClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;

	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "prenom", length = 50, nullable = false)
	private String prenom;
	
	
	 @OneToMany(mappedBy = "clientemprunt")
	 private Set<EEmprunt> emprunts;
	 
	
	public EClient() {
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<EEmprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<EEmprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	

}
