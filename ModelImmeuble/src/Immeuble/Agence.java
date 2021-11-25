package Immeuble;

public class Agence {
	public void louer(Immeuble im,Person[] persons) {
		int i = 0;
		for (Etage etage:im.getEtages()) {
			for (Appartement ap:etage.getApparts()) {
				if (Math.random() > 0.8) {
					louer(persons[i++],ap);
					if (i >= persons.length) {
						return;
					}
				}
			}
		}
	}
	public void louer(Person person,Appartement ap) {
		ap.setContrat(new Contrat(person));
	}
}
