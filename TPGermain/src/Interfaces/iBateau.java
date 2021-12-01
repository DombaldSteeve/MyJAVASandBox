package Interfaces;

public interface iBateau {
	
	public default void flotte() {
		System.out.println("Je flotte");
	}
	
	public default void coule() {
		System.out.println("Je coule");
	}

}
