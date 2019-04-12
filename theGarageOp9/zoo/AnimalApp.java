package theGarageOp9.zoo;

import java.util.Random;

public class AnimalApp {

	public static void main(String[] args) {

		Animal[] animals = new Animal[10];
		Random rand = new Random();
		for (int i = 0; i < animals.length; i++) {
			int r = rand.nextInt(4);
			Animal animal = null;

			switch (r) {
			case 0:
				animal = new Bird("Bird");
				break;
			case 1:
				animal = new Snake("Snake");
				break;
			case 2:
				animal = new Dog("Dog");
				break;
			case 3:
				animal = new Cat("Cat");
				break;
			}
			
			animals[i]=animal;
		}
		
		for(Animal a:animals) {
			System.out.println(a.getName());
			a.makeNoise();
			a.move();
		}

	}

}
