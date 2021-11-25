package TP14;

public class Rond extends Figure {
	public static final int INIT_R=10;
	
	private Point centre;
	private int rayon;
	public Rond(Point centre, int rayon) {
		super();
		this.centre = centre;
		this.rayon = rayon;
	}
	@Override
	public String toString() {
		return "Rond [centre=" + centre + ", rayon=" + rayon + "]";
	}
	public void affiche() {
		System.out.println(this);
	}
	
}	
