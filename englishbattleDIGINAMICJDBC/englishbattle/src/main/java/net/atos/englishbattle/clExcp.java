package net.atos.englishbattle;

public class clExcp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =10;
		int y = 2;
		try {
			for(int z=2;z>=0;z--) {
				int ans = x/z;
				System.out.print(ans+" ");
			}
		}
		catch (Exception e1) {
			// TODO: handle exception
			System.out.println("E1");
		}
		/**
		 * catch (ArithmeticException e1) {
			// TODO: handle exception
			System.out.println("E2");
		}
		 */
	}

}
