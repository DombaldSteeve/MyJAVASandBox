package Immeuble;

import java.util.Date;

public class Contrat {
	Person locataire;
	Date debut;
	Date fin;
	int loyer;
	
	public Contrat(Person locataire, Date debut, Date fin, int loyer) {
		super();
		this.locataire = locataire;
		this.debut = debut;
		this.fin = fin;
		this.loyer = loyer;
	}
	public Contrat(Person locataire) {
		super();
		this.locataire = locataire;
	}
	public Person getLocataire() {
		return locataire;
	}
	public void setLocataire(Person locataire) {
		this.locataire = locataire;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public int getLoyer() {
		return loyer;
	}
	public void setLoyer(int loyer) {
		this.loyer = loyer;
	}
	
	
}
