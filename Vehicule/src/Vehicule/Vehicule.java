package Vehicule;

public abstract class Vehicule {
	
	
	protected Passager[] passagers = new Passager[10]; 
	
	
	protected static int NB_ROUES = 4;

	protected static int recupererNbRoues() {
		return NB_ROUES;
	}
			
	protected String marque;
	protected String modele;
	protected int prix;
	protected int nbRoues;
	
	
	/*****     CONSTRUCTEUR     *****/
	
	
		public Vehicule(String marque, String modele, int prix) {
			this(marque,modele, prix, Vehicule.recupererNbRoues());
		}
		public Vehicule(String marque, String modele, int prix, int nbRoues) {
			super();
			this.marque = marque;
			this.modele = modele;
			this.prix = prix;
			this.nbRoues = nbRoues;
		}


	/*****     ACCESSEURS     *****/
	
		/*****     Getters     *****/
			
		protected String getMarque() {
			return marque;
		}
		
		protected String getModele() {
			return modele;
		}
		
		protected int getPrix() {
			return prix;
		}
	
	
			
	/*****     METHODES     *****/
			
		protected void afficher() {
			System.out.println(toString());
		}
		
		protected void avancer() {
			System.out.println("Je roule !");
		}
		
		protected abstract void freiner();
		
		
		public String toString() {
			return marque + " " + modele + " " + prix + "€.";
		}
		
		protected void ajouterPassager(Passager passager) {
			for(int i = 0; i < passagers.length; i++) {
				if( passagers[i] == null) {
					passagers[i] = passager;
					break;
				}
			}
		}
		
		
		public String afficherPassagers() {
			String sReturn = "";
			for( int i = 0; i < passagers.length; i++) {
				if (passagers[i] != null) {
					sReturn += passagers[i];
				}
			}return sReturn;
		}
				
}
