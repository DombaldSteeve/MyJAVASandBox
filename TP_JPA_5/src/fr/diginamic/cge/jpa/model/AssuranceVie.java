package fr.diginamic.cge.jpa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("2")
public class AssuranceVie extends ECompte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DATEFIN")
	private LocalDate dateFin;
	
	@Column(name = "TAUX")
	private Double taux;
	

	public AssuranceVie() {
		// TODO Auto-generated constructor stub
	}
	

	public AssuranceVie(int id, LocalDate dateFin, Double taux) {
		super();
		this.id = id;
		this.dateFin = dateFin;
		this.taux = taux;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getDateFin() {
		return dateFin;
	}


	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	public Double getTaux() {
		return taux;
	}


	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	

}
