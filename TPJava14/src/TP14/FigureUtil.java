package TP14;

public class FigureUtil {
	private static int getRandomValue(int max,int min) {
		int x = (int)(Math.random()*((double)max));
		return (x < min) ? min:x;
	}
	private static Point getRandomPoint() {
		return new Point(getRandomValue(200, Point.INIT_X),getRandomValue(200, Point.INIT_Y));
	}
	public static Rond getRandomRond() {
		return new Rond(getRandomPoint(),getRandomValue(100, Rond.INIT_R));
	}
	public static Rectangle getRandomRectangle() {
		final int minLen=10;
		final int minHaut=5;
		
		Point p = getRandomPoint();
		int len = getRandomValue(200, minLen);
		int haut = getRandomValue(200, minHaut);
		return new Rectangle(p, len, haut);
	}
	public static Carre getRandomCarre() {
		final int minCote=10;
		
		Point p = getRandomPoint();
		int cote = getRandomValue(100, minCote);
		return new Carre(p, cote);
	}
	public static Figure getRandomFigure() {
		double val = Math.random()*10.0; 
		if (val <= 3.0) {
			return getRandomRond();
		} else if (val <= 6.0) {
			return getRandomCarre();
		} else {
			return getRandomRectangle();
		}
	}
}
