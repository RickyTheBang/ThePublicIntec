package theGarage.garage;

import java.util.Random;

import theGarage.enums.Color;
import theGarage.interfaces.Movable;
import theGarage.interfaces.Paintable;

public abstract class Car implements Movable, Paintable {
	public static int NUMBER_OF_WHEELS = 4;
	private Color color;
	private double speed;
	private static int count;
	static {
		count = 0;
	}
	{
		count++;
	}

	public Car() {

	}

	public Car(Color color) {

		this.color = color;
	}

	
	public Car(Color color, double speed) {
		
		this.color = color;
		this.speed = speed;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public static int getCount() {
		return count;
	}

	@Override
	public void accelerate(double value) {
		this.speed *= (1 + value / 100);

	}

	@Override
	public void slowDown(double value) {
		double newSpeed = this.speed - value;
		if(newSpeed <0) {
			newSpeed= 0;
		}
		this.speed = newSpeed;
	}

	

	@Override
	public void rePaint(Color color) {
		this.color = color;
		
	}

	@Override
	public String toString() {
		return "NUMBER_OF_WHEELS=" + NUMBER_OF_WHEELS +",color=" + color + ", speed=" + speed + " ";
	}
	
	public static Car generateRandomCar() {
		Car car = null;
		Random ran = new Random();
		int pos = ran.nextInt(3)+1;
		switch(pos) {
		case 1:
			car = new FamilyCar();
			break;
		case 2:
			car = new SportCar();
			break;
		case 3:
			car = new Cabriolet();
			break;		
		
		}
		return car;
	}
	

	
	
}
