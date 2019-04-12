package theGarageOp9.zoo;
public class Fish extends Animal {
	
	
	public Fish() {
		this(null);
	}
	public Fish(String name) {
		
		super(name);
	}

	@Override
	public void move() {
		System.out.println("Fish walking");
	}

	@Override
	public void makeNoise() {
		System.out.println("Fish noise");
		
	}

}
