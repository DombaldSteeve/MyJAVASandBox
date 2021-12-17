package fr.diginamic.cge.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Fournisseur")
public class EFournisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // configuration clé primaire elle même en auto incremente dans la BdD
	private int id;
	
	@Column(name = "NOM", length = 25, unique = true)
	private String nom;
	
	/**
	 * On définit l'attribut qui me permet d'avoir la liste des articles du fournisseur (this)
	 * C'est dangereux quand on a bcp de données lié des 2 côtés !
	 */
	 @OneToMany(mappedBy = "fourArticle")
	 private Set<EArticle> articles;
	 

	// commentaire interne uniquement a l'entity donc pas dans la bdd sql
	@Transient
	private String commentaireInterne;
		
	 
	public EFournisseur() {
		// TODO Auto-generated constructor stub
		// pour éviter les bugs s'il n'y a pas d'articles pour ce fournisseur
		articles = new HashSet<>();
	}
	
	

	public String getCommentaireInterne() {
		return commentaireInterne;
	}



	public void setCommentaireInterne(String commentaireInterne) {
		this.commentaireInterne = commentaireInterne;
	}



	public int getId() {
		return id;
	}

	public Set<EArticle> getArticles() {
		return articles;
	}

	public void setArticles(Set<EArticle> articles) {
		this.articles = articles;
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
	
}
