package testBoris;
import java.util.Scanner;

public class CalculatriceParMultiplication {

	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner nombre = new Scanner (System.in);
		
		
		System.out.println("tapez la valeur de votre premier nombre :");
		int nbr1 = nombre.nextInt();
		
		System.out.println("tapez la valeur de votre deuxième nombre :");
		int nbr2 = nombre.nextInt();
		
		int res = nbr1 * nbr2;
		
		System.out.println("Le résultat est " + res);

	}

}
