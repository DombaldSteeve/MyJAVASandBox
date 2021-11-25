package JenfiCours;

public class Personne {

	/* STATIC = CLASSE = recette de cuisine */
	public static int nbPersonnes = 0;
	
	public static String calculSexe(String sexe) {
		if (sexe.equals("M")) {
			return "Masculin";
		}
		else {
			return "Feminin";
		}
 	}

	private static boolean isMajeur(int age) {
		return (age >= 18);
	}
	
	
	
/* NON STATIC = OBJET = plat principal */
	
	private String prenom;
	private String nom;
	private int age;
	private String sexe;
	
	/* CONSTRUCTEURS */
	
	public Personne() {
		this("Toto");
	}
	public Personne(String prenom) {
		this(prenom, "FRANCISCO");
	}
	public Personne(String prenom, String nom) {
		this(prenom, nom, 10);
	}
	public Personne(String prenom, String nom, int age) {
		this(prenom, nom, age, "M");
	}
	public Personne(String prenom, String nom, int age, String sexe) {
		super(); // this = new Personne() = new Object();
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
		this.sexe = Personne.calculSexe(sexe);
	}

	
	/* ACCESSEURS */
	public int getAge() {
		return age * 12;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	
	/* METHODES */
	public void grandir() {
		// v3
		//int age = this.getAge();
		//boolean b = Personne.isMajeur(getAge());
		if(Personne.isMajeur(getAge()) == false){
			grandir(1);	
		}
		
		/* //v2 
		if(!isMajeur()) { grandir(1); }
		*/
		
		/* //v1
		 Boolean b = this.isMajeur();
		if(b == false) {
			this.grandir(1);
		}
		 */
	}
	public void grandir(int incr) {
		age = age + incr;
	}
	
	private boolean isMajeur() {
		return (getAge() >= 18);
		/*
		if (this.age < 18) {
			return false;
		}
		else {
			return true;
		}
		*/
	}

	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + ", age=" + age + ", sexe=" + sexe + "]";
	}
	
	
	
}
