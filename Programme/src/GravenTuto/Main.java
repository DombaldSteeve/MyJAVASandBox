package GravenTuto;

public class Main {

	public static void main(String[] args) {
		
		int money = 300;
		int pricePhone1=289;
		int pricePhone2=325;
		
		if(money >= pricePhone2) {
			System.out.println("The Iphone is buying.");
		} else if (money >= pricePhone1) {
			System.out.println("The Xiaomi is buying.");
		} else {
			System.out.println("You can't buy cell phone...");
		}
	}
}
