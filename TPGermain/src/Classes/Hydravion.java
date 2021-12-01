package Classes;

import Interfaces.iBateau;

public class Hydravion extends Avion implements iBateau {
	
	@Override
	public void atterrir() {
		System.out.println("J'atteris sur la mer et sur la terre.");
	}
	
	
	
}
