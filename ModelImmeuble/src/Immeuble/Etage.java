package Immeuble;

import java.util.Arrays;

public class Etage {

	private int numero;
	private int nbApparts;
	private Appartement[] apparts;
	
	public Etage(int numero, int nbApparts) {
		super();
		this.numero = numero;
		this.nbApparts = nbApparts;
		createEtages();
	}
	
	private void createEtages() {
		apparts = new Appartement[nbApparts];
		for (int i = 0 ; i < nbApparts ; i++) {
			apparts[i] = new Appartement(""+numero+""+i);
		}
	}

	public Appartement[] getApparts() {
		return apparts;
	}

	public void setApparts(Appartement[] apparts) {
		this.apparts = apparts;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getApartsString() {
		return Arrays.toString(apparts);
	}
	
	
}
