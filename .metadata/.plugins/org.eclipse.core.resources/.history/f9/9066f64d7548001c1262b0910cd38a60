package Immeuble;

public class Appartement {
	private String numero;
	private Contrat contrat = null;
	
	public Appartement(String numero) {
		super();
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		String locataireInfo = (contrat == null) ? "LIBRE":("LOUE PAR "+contrat.getLocataire().getNom());
		return "(Apt " + numero + " - "+locataireInfo+ ")";
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
}
