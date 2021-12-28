package fr.diginamic.jdbc.entites;

public class Article {

	private int id;
	private String ref;
	private String designation;
	private double prix;
	private int id_fou;
	
	public Article() {
		
	}
	
	//Constructeur
	
	public Article(int id, String ref, String designation, double prix, int id_fou) {
		super();
		this.id = id;
		this.ref = ref;
		this.designation = designation;
		this.prix = prix;
		this.id_fou = id_fou;
	}


	//Getter et Setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getId_fou() {
		return id_fou;
	}


	public void setId_fou(int id_fou) {
		this.id_fou = id_fou;
	}


	@Override
	public String toString() { 
		return "Articles [id = " + id + ", ref = " + ref + ", designation = " + designation + ", prix = " + prix + ", id_fou = "
				+ id_fou + "]\n";
	}
	
	
	
	
	

}
