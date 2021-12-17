package fr.diginamic.cge.jpa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "BON")
public class EBon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // autoincré
	private int id;
	
	private int numero;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CMDE")
	private Date dateCmde; // = date_cmde
	
	private int delai;
	
	@ManyToOne
	@JoinColumn(name = "ID_FOU")
	private EFournisseur fourBon;
	
	@ManyToMany //pour relation n n 
	@JoinTable(name = "COMPO01", // on donne le nom de la table physique compo01 est une table de relation
			joinColumns = @JoinColumn(name = "ID_BON", referencedColumnName = "ID"),// a partir de bon je fais le lien de idbon a ID de la table BON
			inverseJoinColumns = @JoinColumn(name = "ID_ART", referencedColumnName = "ID") // c'est le lien de la colonne id art de compo01 vers le ID de  la table article
			)
	private Set<EArticle> bonArticles;
	
	 
	
	public EBon() {
		// TODO Auto-generated constructor stub
		bonArticles = new HashSet<>(); // pour eviter les bugs faut le faire tout le temps
	}
	
	
	public Set<EArticle> getBonArticles() {
		return bonArticles;
	}

	public void setBonArticles(Set<EArticle> bonArticles) {
		this.bonArticles = bonArticles;
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

	public Date getDateCmde() {
		return dateCmde;
	}

	public void setDateCmde(Date dateCmde) {
		this.dateCmde = dateCmde;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public EFournisseur getFourBon() {
		return fourBon;
	}

	public void setFourBon(EFournisseur fourBon) {
		this.fourBon = fourBon;
	}
	

}
