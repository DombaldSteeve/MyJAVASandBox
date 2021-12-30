package fr.diginamic.cge.jpa.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class ELivre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "TITRE", length = 75, nullable = false)
	private String titre;
	
	@Column(name = "auteur", length = 50, nullable = false)
	private String auteur;
	
	@ManyToMany //pour relation n n 
	@JoinTable(name = "COMPO", // on donne le nom de la table physique compo01 est une table de relation
			joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),// a partir de bon je fais le lien de idbon a ID de la table BON
			inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID") // c'est le lien de la colonne id art de compo01 vers le ID de  la table article
			)
	private Set<EEmprunt> livreEmprunts;
	
	
	public ELivre(int id, String titre, String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
	}

	public ELivre() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Set<EEmprunt> getLivreEmprunts() {
		return livreEmprunts;
	}

	public void setLivreEmprunts(Set<EEmprunt> livreEmprunts) {
		this.livreEmprunts = livreEmprunts;
	}


}
