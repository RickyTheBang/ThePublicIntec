package theGarageOp9.zoo;

public class MainApp {

	public static void main(String[] args) {
		Animal animal1 = new Cat("Sasha");
		Animal animal2 = new Dog("Marcel");
		Animal animal3 = new Bird("Jacko");
		Animal animal4 = new Fish("freddy");
		
		System.out.println(animal1.getName());
		animal1.makeNoise();

	}

}
