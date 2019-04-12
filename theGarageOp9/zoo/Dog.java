package theGarageOp9.zoo;

public class Dog extends Animal{
	
	public Dog() {
		this(null);
	}
	public Dog(String name) {
		
		super(name);
	}


	@Override
	public void move() {
		System.out.println("Dog walking");
		
	}

	@Override
	public void makeNoise() {
		System.out.println("Dog noise");
		
	}

}
