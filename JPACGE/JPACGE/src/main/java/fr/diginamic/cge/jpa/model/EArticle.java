package fr.diginamic.cge.jpa.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name = "ARTICLE")
public class EArticle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // pour l'auto incrementation
	private int id;
	
	
	/**
	 *taille max de 13 caractère et valeur qui ne peut être null 
	 */
	@Column(name = "REF", length = 13, nullable = false)
	private String reference;
	
	
	/**
	 * Taille maxi de 255 car non null
	 */
	@Column(name = "DESIGNATION", length = 255, nullable = false)
	private String designation;
	
	
	private Double prix;
	
	/**
	 * création d'une relation de typé Clé étrangère entre article et fournisseur
	 * ce qui veut dire en JPA entre EArticle et EFournisseur
	 * n Article lié à 1 fournisseur
	 */
	@ManyToOne
	@JoinColumn(name = "ID_FOU")
	private EFournisseur fourArticle;
	
	
	@ManyToMany(mappedBy = "bonArticles")
	private Set<EBon> articleBons;
	



	public EArticle() {
		// TODO Auto-generated constructor stub
	}


	public Set<EBon> getArticleBons() {
		return articleBons;
	}



	public void setArticleBons(Set<EBon> articleBons) {
		this.articleBons = articleBons;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getReference() {
		return reference;
	}



	public void setReference(String reference) {
		this.reference = reference;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public Double getPrix() {
		return prix;
	}



	public void setPrix(Double prix) {
		this.prix = prix;
	}



	public EFournisseur getFourArticle() {
		return fourArticle;
	}



	public void setFourArticle(EFournisseur fourArticle) {
		this.fourArticle = fourArticle;
	}
	
	

}
