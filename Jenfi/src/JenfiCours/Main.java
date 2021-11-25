package JenfiCours;

public class Main {

	/* RECETTE */
	public static void main(String[] args) {
		//String sexe = Personne.calculSexe("M");
		//System.out.println(sexe);

		Personne p = new Personne("Toto", "DURANT");
		
		String persLib = p.toString();
		
		System.out.println(persLib);

		//String libSexe = Personne.calculSexe("F");
		//p.setSexe(libSexe);
		//p.setSexe(Personne.calculSexe("F"));
		int age = p.getAge();
		System.out.println("a = "+ age);
		p.grandir();
		age = p.getAge();
		System.out.println("b = "+ age);
		p.grandir(5);
		age = p.getAge();
		System.out.println("c = "+ age);
				
		//System.out.println("old age = "+ age +" & new age = "+ p.getAge());
	}
	
	
	/* PLAT PRINCIPAL */

}
