package ExerciceOudja;

public class Voiture {
	
	public String marque;
	public Double prix;
	
	
	public Voiture(String marque, Double prix) {
		this.marque = marque;
		this.prix = prix;
	}


	
	public String getMarque() {
		return marque;
	}
	public Double getPrix() {
		return prix;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	
	
	public void afficher() {
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return "Cette voiture de marque " + getMarque() + " coûte un prix de " + getPrix() + "€.";
	}
	
	
	
	

}
