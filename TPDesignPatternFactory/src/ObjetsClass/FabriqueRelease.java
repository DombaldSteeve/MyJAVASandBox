package ObjetsClass;

import Patterns.Classe;
import Patterns.Fabrique;

class FabriqueRelease implements Fabrique {
	public Classe creerClasse() {
		return new ClasseRelease();
	}
}
