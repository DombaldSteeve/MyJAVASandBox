package TP11;

public class Rectangle {
	private Point pointHautGauche;
	private Point pointBasGauche;
	private Point pointHautDroit;
	private Point pointBasDroit;
	public Rectangle(Point pointHautGauche,int len,int hauteur) {
		this.pointHautGauche = pointHautGauche;
		pointBasGauche = new Point(pointHautGauche.getX(),pointHautGauche.getY()+hauteur);
		pointBasDroit = new Point(pointHautGauche.getX()+len,pointHautGauche.getY()+hauteur);
		pointHautDroit = new Point(pointHautGauche.getX()+len,pointHautGauche.getY());
	}
	public Point getPointHautGauche() {
		return pointHautGauche;
	}
	public void setPointHautGauche(Point pointHautGauche) {
		this.pointHautGauche = pointHautGauche;
	}
	public Point getPointBasGauche() {
		return pointBasGauche;
	}
	public void setPointBasGauche(Point pointBasGauche) {
		this.pointBasGauche = pointBasGauche;
	}
	public Point getPointHautDroit() {
		return pointHautDroit;
	}
	public void setPointHautDroit(Point pointHautDroit) {
		this.pointHautDroit = pointHautDroit;
	}
	public Point getPointBasDroit() {
		return pointBasDroit;
	}
	public void setPointBasDroit(Point pointBasDroit) {
		this.pointBasDroit = pointBasDroit;
	}
	@Override
	public String toString() {
		return "Rectangle [pointHautGauche=" + pointHautGauche + ", pointBasGauche=" + pointBasGauche
				+ ", pointHautDroit=" + pointHautDroit + ", pointBasDroit=" + pointBasDroit + "]";
	}
	
	public void affiche() {
		System.out.println(this);
	}
}
