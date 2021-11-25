package testBoris;
import java.util.Scanner;
import java.util.Locale;


public class PrixHtTttc {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.US);
		
		double prixHT;
		System.out.print("Prix Hors Taxe? ");
		prixHT = input.nextDouble();
		
		double taux;
		taux = (prixHT*0.2);
		
		double prixTTC = prixHT + taux;
		System.out.println("==> Avec un prix HT de " + prixHT + " le prix TTC vaut " + prixTTC);
		
		}
}
		




