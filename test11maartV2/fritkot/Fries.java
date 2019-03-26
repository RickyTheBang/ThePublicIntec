package test11maartV2.fritkot;

public class Fries implements Fryable, Orderable {
	private FrySizes size;	;
	private static int portionCount;
	
	static {
		portionCount=0;
	}
	{
		portionCount++;
	}
	
	
	
	public Fries() {
		
		
		
	}

	public Fries(FrySizes size) {	
		this.size = size;
		
	}

	public FrySizes getSize() {
		return size;
	}

	public void setSize(FrySizes size) {
		this.size = size;
	}

	public static int getPortionCount() {
		return portionCount;
	}

	

	@Override
	public double getPrice() {
		return this.getSize().getPrice();
	}

	@Override
	public void Fry() {
		System.out.println("The chef is frying fries of " + this.getSize() + " size.");

	}
	
	public double calculatePrice() {
		
		return getPrice();
		
		
		
	}

}
