package MainPack;

import ObjetsClass.EnceinteConnectee;
import ObjetsClass.ObjetConnecte;

public class App {
	
	public static  getObjetConnecte(int typeObject, int limite) {
		if(typeObject == 1) {
			return new EnceinteConnectee(limite);
		}
	}

}
