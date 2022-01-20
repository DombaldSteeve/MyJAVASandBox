package ObjetsClass;

import Patterns.Classe;

class ClasseDebug implements Classe {
public String getType() {
return this.getClass().getName();
}
}

