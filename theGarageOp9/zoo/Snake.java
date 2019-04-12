package theGarageOp9.zoo;

public class Snake extends Animal{
	
	public Snake() {
		this(null);
	}
	public Snake(String name) {
		
		super(name);
	}

	@Override
	public void move() {
		System.out.println("Snake walking");
		
	}

	@Override
	public void makeNoise() {
		System.out.println("Snake noise");
		
	}

}
