package fr.diginamic.builder;

import fr.diginamic.entities.Animal;
import fr.diginamic.entities.Zone;
import fr.diginamic.entities.Zoo;

public class ZooBuilder {
	
	private Zoo zoo;
	private Zone zone;
	private Animal animal;
	
	
	public ZooBuilder(String nom) {
		this.zoo = new Zoo();
	}
	
	public ZooBuilder appendZone(String nom, int capacite) {
		zone.setNom(nom);
		zone.setCapacite(capacite);
		return this;
	}
	
	public ZooBuilder appendAnimal(String nomZone, Animal animal) {
		animal.setNom(nomZone);
		
		return this;
		
		
		
	}

}
