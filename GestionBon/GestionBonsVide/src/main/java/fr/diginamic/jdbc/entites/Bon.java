package fr.diginamic.jdbc.entites;

import java.util.Date;

public class Bon {
	
	private int id;
	private int numero;
	private Date datecmde;
	private int delai;

	
	public Bon () {
		
	}
	
	public Date getDatecmde() {
		return datecmde;
	}

	public void setDatecmde(Date datecmde) {
		this.datecmde = datecmde;
	}

	public Bon(int id, int numero, Date datecmde, int inputInsertDelai) {
		super();
		this.id = id;
		this.numero = numero;
		this.datecmde = datecmde;
		this.delai = inputInsertDelai;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	@Override
	public String toString() {
		return "Bon [id = " + id + ", numero = " + numero + ", datecmde = " + datecmde + ", delai = " + delai + "]";
	}



}
