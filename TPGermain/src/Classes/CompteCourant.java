package Classes;

public class CompteCourant {
	
	private Double solde = 0.0;
	
	public CompteCourant() {
		this(0.0);
	}

	public CompteCourant(Double solde) {
		this.solde = solde;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	

}
