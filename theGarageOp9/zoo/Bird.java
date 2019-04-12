package theGarageOp9.zoo;

public class Bird extends Animal{
	
	public Bird() {
		this(null);
	}
	public Bird(String name) {
		
		super(name);
	}

	@Override
	public void move() {
		System.out.println("Bird walk");
		
	}

	@Override
	public void makeNoise() {
		System.out.println("Bird noise");
		
	}

}
