package NbsPremiers;

import java.util.Scanner;

public class PrimeNumbs {
	
	
	
	
	public static void main(String args[]) {
	
		   Scanner input=new Scanner(System.in);
		    System.out.printf ("Vous voulez les nombres premiers inférieurs à quel nombre ? ");
		    int valeurMax=Integer.parseInt(input.nextLine());
		    System.out.printf ("%s%s\n","Voici la liste des nombres premiers inférieurs à : ", valeurMax); 
			for (int i = 2; i < valeurMax; i++)
			{
			if ( i % 2 == 0 && i / 2 > 1)
				continue;
			else if ( i % 3 == 0 && i / 3 > 1)
	  			continue;
			else if ( i % 5 == 0 && i / 5 > 1)
	   			continue;
		   else if ( i % 7 == 0 && i / 7>1)
				continue;

				System.out.println (i);
			}
	
	}

}
