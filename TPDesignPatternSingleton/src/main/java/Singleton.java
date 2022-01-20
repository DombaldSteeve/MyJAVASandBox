
public class Singleton {
	
	private static Singleton instance = null;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if (Singleton.instance == null) {
			Singleton.instance = new Singleton();
		}
		return Singleton.instance;
	}
	
	public void read() {
	Singleton configuration = Singleton.getBundle("configuration") ;
	String valeur = configuration.getString("db.url");
	System.out.println(valeur);
	}
	
}
