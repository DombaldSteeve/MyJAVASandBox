package fr.diginamic.cge.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.diginamic.cge.jpa.enumeration.Genre;

@Entity
@Table(name = "FOUR01")
public class EFour01 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOM", length= 25)
	private String nom;
	
	/**
	 * Enumération mysql de type string 'M' , 'Mme'
	 * Je dois préciser la synthaxe SQL de la definition de l'numération de MySQL
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "GENRE", columnDefinition = "enum('M' , 'Mme')")
	private Genre genre;
	
	

	public EFour01() {
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



	public Genre getGenre() {
		return genre;
	}



	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	public static void main(String[] args) {
		
	}

}
