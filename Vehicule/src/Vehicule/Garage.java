package Vehicule;

import java.util.ArrayList;
import java.util.List;

public class Garage {

	List<Voiture> voitures = new ArrayList<Voiture>();

	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}
	
	
	public void ajouterVoiture(Voiture uneVoiture) {
		voitures.add(uneVoiture);
	}

	@Override
	public String toString() {
		String str = "";
		for( Voiture v : voitures) {
			str += "Marque : " + v.getMarque() + " Modèle : " + v.getModele() + " Prix " + v.getPrix() + ".\n";	
		}
		return str;
	}
	
	
	
	
	
	
	
}
