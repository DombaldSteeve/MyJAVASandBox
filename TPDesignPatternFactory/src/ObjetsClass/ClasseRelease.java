package ObjetsClass;

import Patterns.Classe;

class ClasseRelease implements Classe {
public String getType() {
return this.getClass().getName();
}
}
