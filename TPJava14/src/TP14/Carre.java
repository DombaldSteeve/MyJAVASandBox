package TP14;


public class Carre extends Rectangle {

	public Carre(Point pointHautGauche, int cote) {
		super(pointHautGauche, cote, cote);
	}
	protected String getType() {
		return "Carre";
	}
}
