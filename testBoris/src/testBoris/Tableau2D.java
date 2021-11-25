package testBoris;

public class Tableau2D {
	
	public static void main(String[] args) {
		int a[][] = new int[6][13];
		// remplissage
		for (int i = 0 ; i < 6 ; i++) {
			for (int j = 0 ; j < 13 ; j++) {
				a[i][j] = (int)Math.floor((Math.random() * 9) + 1.0);
			}
		}
		// affichage
		for (int i = 0 ; i < 6 ; i++) {
			for (int j = 0 ; j < 13 ; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
		
