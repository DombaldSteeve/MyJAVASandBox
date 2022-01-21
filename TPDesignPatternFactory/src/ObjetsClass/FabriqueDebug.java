package ObjetsClass;

import Patterns.Classe;
import Patterns.Fabrique;

class FabriqueDebug implements Fabrique {
public Classe creerClasse() {
return new ClasseDebug();
}
}
