package EvalJC;

public class Item {
	
	
	private Long id;
	private String name;
	private Double prix;
	
	
	public Item(Long id, String name, Double prix) {
		super();
		this.id = id;
		this.name = name;
		this.prix = prix;
	}
	
	
	
	/****    Getters    ****/
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getPrix() {
		return prix;
	}
	
	
	/**** Setters    ****/
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	
	
	

}
