package Vehicule;

public class MainVehicule {

	public static void main(String[] args) {
		
		Voiture vtr = new Voiture("Renault", "Clio", 3823, 5);
		
		Camion cmn;
		try {
			cmn = new Camion("Mercedes", "B855", 13000 , 3.5);
			cmn.afficher();
		} catch (MarqueInvalideException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Fini");
		}
		
		Cabriolet cbl = new Cabriolet("BMW", "Z3", 23000);
		
		Passager p1 = new Passager("Duduche", "Pierre");
		Passager p2 = new Passager("Durant", "Nicolas");
		
		Passager [] tp1 = { new Passager("Seb", "Landri"), new Passager("Jean", "Truc"), new Passager("Nico", "Batum"), new Passager("Rudy", "Gobert") };
		
		Garage g1 = new Garage();
		for(int i=0; i < 10; i++) {
			g1.ajouterVoiture(new Voiture("Renault"+i, "Modus"+i, 6300*i));
		}
		
		System.out.println(g1);
		
		vtr.ajouterPassager(p1);
		vtr.ajouterPassager(p2);
		vtr.ajouterPassager(tp1);
		vtr.afficher();
		
		System.out.println();
		
		
		System.out.println();
		
		cbl.afficher();
		cbl.freiner();
		
	}

}
