package test11maartV2.fritkot;

public class Sauce implements Orderable {
	private double price = 0.8;
	private String name;
	
	
	public Sauce() {

}

	public Sauce(String name) {
			this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getPrice() {
		
		return price;
	}

}
