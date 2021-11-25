package TP11;

public class Main {
	
	public static void main(String[] args) {
		Rond rond = FigureUtil.getRandomRond();
		rond.affiche();
		Rectangle r = FigureUtil.getRandomRectangle();
		r.affiche();
	}
}
