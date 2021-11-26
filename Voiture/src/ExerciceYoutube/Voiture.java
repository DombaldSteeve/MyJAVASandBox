package ExerciceYoutube;

public class Voiture {
	
	
	public String marque;
	public Double prix;
	
	/*****     CONSTRUCTEUR     *****/
	
	public Voiture (String marque, Double prix) {
		super();
		this.marque = marque;
		this.prix = prix;
		
	}
	
	
	
	/*****     Accesseurs     *****/
	
	public void setMarque(String mrq) {
		this.marque = mrq;
	}
	
	public void setPrix(Double prx) {
		this.prix = prx;
	}
	
	
	
	
	public void afficher() {
		System.out.println(toString);
	}
	
	public  String toString() {
		return " La voiture est de marque " + marque + " et coûte " + prix;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
