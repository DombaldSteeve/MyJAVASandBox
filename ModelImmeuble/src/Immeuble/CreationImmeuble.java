package Immeuble;

public class CreationImmeuble {
	public static void main(String[] args) {
		Person[] persons = {new Person("Martin"),new Person("Dupont"),new Person("Durand"),new Person("Machin"),new Person("Roberto"),new Person("Gomez")};
		Immeuble im = new Immeuble(4, 6);
		Agence ag = new Agence();
		ag.louer(im, persons);
		im.display();
	}
}

