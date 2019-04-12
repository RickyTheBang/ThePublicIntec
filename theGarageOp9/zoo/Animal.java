package theGarageOp9.zoo;

public abstract class Animal {
	
	public Animal() {
		this(null);
	}
	public Animal(String name) {
		
		this.name = name;
	}
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void move();
	public abstract void makeNoise();
	

}
