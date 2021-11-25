package TP;

public class Main {
	
	public static void main(String[] args) {
		Point p = new Point(100,100);
		Rond rond = new Rond(p,50);
		rond.affiche();
		Rectangle r = new Rectangle(p, 100, 50);
		r.affiche();
		
	}
}
