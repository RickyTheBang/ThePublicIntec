package test11maartV2.fritkot;

public class FryMain {

	public static void main(String[] args) {

		Fryshack jammies = new Fryshack("Jammies");
	
		jammies.makeOrders();
		
		System.out.print("The number of orders is :");
		System.out.println(Order.getOrderNumber());
		System.out.print("The number of fries is :");
		System.out.println(Fries.getPortionCount());
		
	
		
	
		
	}

}
