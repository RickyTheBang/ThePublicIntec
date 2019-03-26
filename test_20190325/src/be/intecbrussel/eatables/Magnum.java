package be.intecbrussel.eatables;

public class Magnum implements Eatable {
	public enum MagnumType {
			MILKCHOCOLATE(1.5),WHITECHOCOLATE(2),BLACKCHOCOLATE(2.5),ALPINENUTS(3.0),ROMANTICSTRAWBERRIES(4);
		
		private double multiplicator;

		private MagnumType(double multiplicator) {
			this.multiplicator = multiplicator;
		}

		public double getMultiplicator() {
			return multiplicator;
		}
		
	}
	MagnumType type;
	
	public Magnum() {
		
		
	}

	public Magnum(MagnumType type) {
	
		this.type = type;
	}
	public MagnumType getType() {
		return type;
	}

	@Override
	public void eat() {
		String message = "I am eating a " + getType() + " Magnum.";		
		System.out.println(message);		
	}
	
}
