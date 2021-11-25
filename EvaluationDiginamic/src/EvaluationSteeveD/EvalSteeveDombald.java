package EvaluationSteeveD;

import java.util.Scanner;

public class EvalSteeveDombald {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez une valeur entre 21 et 69");
		int valeur = input.nextInt();
		
		if (valeur >= 21 && valeur <= 69) {
			
			int valeurDizaine = valeur/10;
				switch (valeurDizaine) {
				
				case 2:
					System.out.print("vingt ");
					break;
				case 3:
					System.out.print("trente ");
					break;
				case 4:
					System.out.print("quarante ");
					break;
				case 5:
					System.out.print("cinquante ");
					break;
				case 6:
					System.out.print("soixante ");
					break;
				}
				
				int valeurUnite = valeur-(valeurDizaine*10);	
					switch (valeurUnite) {
					
					
					case 1:
						System.out.print("et un");
						break;
					case 2:
						System.out.print("deux");
						break;
					case 3:
						System.out.print("trois");
						break;
					case 4:
						System.out.print("quatre");
						break;
					case 5:
						System.out.print("cinq");
						break;
					case 6:
						System.out.print("six");
						break;
					case 7:
						System.out.print("sept");
						break;
					case 8:
						System.out.print("huit");
						break;
					case 9:
						System.out.print("neuf");
						break;
					}
				
			}

	}

}
