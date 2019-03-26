package be.intecbrussel.eatables;

public class Cone implements Eatable {
	public enum Flavor {

		STRAWBERRY, BANANA, CHOCOLATE, VANILLA, LEMON, STRACIATELLA, MOKKA, PISTACHE;
	}

	private Flavor[] balls;

	public Cone() {

	}

	public Cone(Flavor[] balls) {

		this.balls = balls;
	}

	@Override
	public void eat() {
		int arrayLenght = balls.length;
		String message = "I am eating a cone with " + arrayLenght + " ball" + ((arrayLenght > 1) ? "s" : "") + ". ";
		message += "My choice of flavor is the following: ";
		for (int i = 0; i < arrayLenght; i++) {
			if (i < arrayLenght - 1) {
				message += balls[i] + ", ";
			} else {
				message += balls[i] + ".";
			}
		}
		System.out.println(message);

	}

}
