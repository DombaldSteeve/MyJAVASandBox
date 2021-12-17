package fr.diginamic.cge.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPRUNT")
public class EEmprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_DEBUT")
	private Date dateDebut; 
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_FIN")
	private Date dateFin; 
	
	private int delai;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private EClient idClient;
	
	
	public EEmprunt() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public int getDelai() {
		return delai;
	}


	public void setDelai(int delai) {
		this.delai = delai;
	}


	public EClient getIdClient() {
		return idClient;
	}


	public void setIdClient(EClient idClient) {
		this.idClient = idClient;
	}
	
	

}
