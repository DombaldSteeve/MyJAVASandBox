package ObjetsClass;

public class FabriqueObject extends Fabrique {

	@Override
	public ObjetConnecte getObjetConnecte(int typeObject, int limite) {
		if (typeObject == 0) {
			return null;
		} if (typeObject == 1) {
			return new EnceinteConnectee(limite);
		} if (typeObject == 2) {
			return new Tablette(limite);
		} if (typeObject == 3) {
			return new TelephonePortable(limite);
		}
		return null;
	}

}
