package TP11;

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
}
