package Vehicule;

public abstract class Vehicule implements BoiteVitesse {
	
	protected Integer vitesseEnclenchee = 0;
	
	// tableau de passagers pour une instance véhicule
	protected Passager[] passagers; 
	protected static final int NB_PLACES = 5;
	
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
			this(marque,modele, prix, Vehicule.recupererNbRoues(), NB_PLACES);
		}
		public Vehicule(String marque, String modele, int prix, int nbRoues, int nbPlaces) {
			super();
			this.marque = marque;
			this.modele = modele;
			this.prix = prix;
			this.nbRoues = nbRoues;
			this.passagers = new Passager[nbPlaces];
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
		
		protected void ajouterPassager(Passager[] autrePassagers) {
			for (int i = 0; i < autrePassagers.length; i++) {
				ajouterPassager(autrePassagers[i]);
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
		
		public void passerVitesse() {
			if(vitesseEnclenchee < 6) {
				vitesseEnclenchee++;
				System.out.println("Rapport supérieur passé ! "+ getMarque() + " " + getModele() + " est au rapport n° " + vitesseEnclenchee);
			} return;
		}
		
		public void retrograder() {
			if(vitesseEnclenchee >= 6) {
				vitesseEnclenchee--;
				System.out.println("Rapport inférieur passé ! "+ getMarque() + " " + getModele() + " est au rapport n° " + vitesseEnclenchee);
			} else {
				vitesseEnclenchee--;
				System.out.println("Rapport inférieur passé ! "+ getMarque() + " " + getModele() + " est au rapport n° " + vitesseEnclenchee);
			}
		}
		
		public void accelerer() {
			passerVitesse();
		}
		
		public void ralentir() {
			retrograder();
		}
				
}
