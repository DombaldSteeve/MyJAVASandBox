package Classes;

public class nb_personnes {
	
	private int nb_personnes = 0;
	
	public nb_personnes() {
		this(0);
		
	}

	public nb_personnes(int nb_personnes) {
		this.nb_personnes = nb_personnes;
	}

	public int getNb_personnes() {
		return nb_personnes;
	}

	public void setNb_personnes(int nb_personnes) {
		this.nb_personnes = nb_personnes;
	}

}
