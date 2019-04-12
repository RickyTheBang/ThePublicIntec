package theGarageOp9.zoo;

public class Cat extends Animal {
	
	public Cat() {
		this(null);
	}
	public Cat(String name) {
		
		super(name);
	}

	@Override
	public void move() {
		System.out.println("Cat walking");
		
	}

	@Override
	public void makeNoise() {
		System.out.println("Cat noise");
		
	}

}
