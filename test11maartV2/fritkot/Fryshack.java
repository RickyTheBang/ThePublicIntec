package test11maartV2.fritkot;

public class Fryshack {

	private String name;

	private Order order;

	public Fryshack(String string) {
		this.name = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void makeOrders() {
		makeOrderOne();
		makeOrderTwo();
		makeOrderTree();
		makeOrderFour();
	}

	// make an order by making Fries, Sauce and Drink Objects and setting them with
	// there Setters
	private void makeOrderOne() {

		Order order1 = new Order();

		order1.setFries(new Fries(FrySizes.BIG));
		order1.setFries(new Fries(FrySizes.MEDIUM));
		order1.setSauce(new Sauce("Mayonnaise"));
		order1.setSauce(new Sauce("Ketchup"));
		order1.setDrink(new Water());
		order1.setDrink(new Soda());
		order1.fryOrder();
		printDetails(order1);

	}

	// make an order by making new Fries, Sauce and Drink Objects and setting them
	// with there Constructors
	private void makeOrderTwo() {
		Order order2 = new Order();
		Fries friesOrder = new Fries(FrySizes.FAMILY);
		Sauce sauceOrder1 = new Sauce("Mayonaise");
		Sauce sauceOrder2 = new Sauce("Mayonaise");
		Sauce sauceOrder3 = new Sauce("Ketchup");
		Water drinkOrder1 = new Water();
		Soda drinkOrder2 = new Soda();
		Soda drinkOrder3 = new Soda();
		Soda drinkOrder4 = new Soda();
		order2.setOrders((new Orderable[] { friesOrder, sauceOrder1, sauceOrder2, sauceOrder3, drinkOrder1, drinkOrder2,
				drinkOrder3, drinkOrder4 }));

		order2.fryOrder();
		;
		printDetails(order2);
	}

	// make an onlineOrder with a Orderable array
	private void makeOrderTree() {
		Order order3 = new Order();
		Orderable[] orders = new Orderable[] { new Fries(FrySizes.BIG), new Sauce("Mayonaise"), new Beer() };
		order3.setOrders(orders);
		order3.fryOrder();
		printDetails(order3);

	}

	// make an your own Order
	private void makeOrderFour() {
		Orderable[] orders = new Orderable[] { new Fries(FrySizes.MEDIUM), new Fries(FrySizes.FAMILY),
				new Sauce("Black Sauce"), new Sauce("Mayonaise"), new Sauce("Barbecue Sauce"), new Beer(), new Water(),
				new Soda() };
		Order order4 = new Order(orders);
		order4.fryOrder();

		printDetails(order4);

	}

	public static void printDetails(Order orders) {
		System.out.println("your order is:");
		Fries[] fr = orders.getFries();
		for (int i = 0; i < fr.length; i++) {
			System.out.println("one fries " + fr[i].getSize().name() + " size");
		}

		Sauce[] sc = orders.getSauce();
		for (int i = 0; i < sc.length; i++) {
			System.out.println("one sauce " + sc[i].getName());
		}

		Drink[] dr = orders.getDrink();
		for (int i = 0; i < dr.length; i++) {
			System.out.println("one glass " + dr[i].getClass().getSimpleName());
		}

		System.out.print("The total amount of your command is: ");
		System.out.println(orders.CalculateTotalPrice());
		System.out.println();

	}

}
