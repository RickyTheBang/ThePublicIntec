package test11maartV2.fritkot;

import java.util.Arrays;



public class Order {

	private Orderable[] orders = new Orderable[0];
	
	private static int orderCount;

	static {
		orderCount = 0;
	}
	{
		orderCount++;
	}

	public Order() {
	}

	public Order(Orderable[] orders) {
		this.orders = orders;
	}


	public Fries[] getFries() {
		
		Fries[] output = new Fries[orders.length];
		int i = 0;
		for(Orderable o : orders)
		{
			if(o instanceof Fries) {
				output[i++]= (Fries)o;
			}
		}
		
		output = Arrays.copyOf(output, i);
			
		return output;
	}

	public void setFries(Fries fries) {
		addOrderable(fries);
	}

	public Sauce[]  getSauce() {
		Sauce[] output = new Sauce[orders.length];
		int i = 0;
		for(Orderable o : orders)
		{
			if(o instanceof Sauce) {
				output[i++]= (Sauce)o;
			}
		}
		
		output = Arrays.copyOf(output, i);
			
		return output;
	}

	public void setSauce(Sauce sauce) {
		addOrderable(sauce);
	}

	public Drink[]  getDrink() {
		Drink[] output = new Drink[orders.length];
		int i = 0;
		for(Orderable o : orders)
		{
			if(o instanceof Drink) {
				output[i++]= (Drink)o;
			}
		}
		
		output = Arrays.copyOf(output, i);
			
		return output;
	}

	public void setDrink(Drink drink) {
		addOrderable(drink);
	}

	public void setOrders(Orderable[] orders) {
		this.orders = orders;
	}


	public Orderable[] getOrders() {
		return orders;
	}

	public static int getOrderCount() {
		return orderCount;
	}

	public double CalculateTotalPrice() {
		double total = 0;
		for (Orderable o : orders) {
			total += o.getPrice();
		}

		return total;
	}

	// Put everything in fryer
	public void fryOrder() {
	
		for (Orderable o : orders) {
			if (o instanceof Fries) {
				((Fries)o).Fry();
				
			}

	}
	
	}
	public void addOrderable(Orderable orderable) {
		Orderable[] output = new Orderable[orders.length + 1];
		
		for(int i = 0; i<orders.length;i++) {
			output[i] = orders[i];
		}
		output[output.length - 1] = orderable;

		this.orders = output;
	}


	public static int getOrderNumber() {
		return orderCount;
	}

	
}
