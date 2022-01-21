package ObjetsClass;

public abstract class Fabrique {
	
	public abstract ObjetConnecte getObjetConnecte(int typeObject, int limite);
	
	public static Fabrique getFabrique(int type) {
		if (type == 1) {
			return new FabriqueObject();
		} if (type == 2) {
			return new FabriqueObject();
		} if (type == 3) {
			return new FabriqueObject();
		} 
		return null;
	}

}
