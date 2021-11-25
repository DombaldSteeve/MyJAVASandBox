package TP11;

public class Point {
	public static final int INIT_X = 25;
	public static final int INIT_Y = 25;

	private int x;
	private int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Point() {
		x = INIT_X;
		y = INIT_Y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
