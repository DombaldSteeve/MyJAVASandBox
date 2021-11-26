package Vehicule;

public class MainVehicule {

	public static void main(String[] args) {
		
		Voiture vtr = new Voiture("Renault", "Clio", 3823, 5);
		
		Camion cmn = new Camion("Mercedes", "B855", 13000 , 3.5);
		
		Cabriolet cbl = new Cabriolet("BMW", "Z3", 23000);
		
		Passager p1 = new Passager("Duduche", "Pierre");
		Passager p2 = new Passager("Durant", "Nicolas");
		vtr.ajouterPassager(p1);
		vtr.ajouterPassager(p2);
		vtr.afficher();
		
		System.out.println();
		
		cmn.afficher();
		
		System.out.println();
		
		cbl.afficher();
		cbl.freiner();
		
	}

}
