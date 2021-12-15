package net.atos.englishbattle;

public class clMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int x = -1;
		final int y = 1_2_4551;
		
		System.out.println(y);
		
		switch (x+y) {
		case x+1:
			{ System.out.println("A");}
		case 1:
			System.out.println("B");	
		default: System.out.println("default");	break;
		case y:
			System.out.println("C");	
		}

	}

}
