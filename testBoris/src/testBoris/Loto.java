package testBoris;

public class Loto {

	public static void main(String[] args) {
		
				int a[] = new int[10];
				// remplissage
				for (int i = 0 ; i < 10 ; i++) {
					a[i] = (int)Math.floor((Math.random() * 100.0) + 1.0); 
				}
				// affichage
				for (int i:a) {
					System.out.println(i);
				}
			}

		

	}
