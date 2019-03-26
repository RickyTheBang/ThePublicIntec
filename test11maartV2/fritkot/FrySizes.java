package test11maartV2.fritkot;

public enum FrySizes {
	SMALL(1.5),MEDIUM(2.5),BIG(3),FAMILY(4.5) ;
	
	
	private double price;
	
	private FrySizes(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
	

	
	

}
