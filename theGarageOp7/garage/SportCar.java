package theGarageOp7.garage;

import theGarageOp7.enums.Color;
import theGarageOp7.factory.CarType;

public class SportCar extends Car {

	public static final int NUMBER_OF_SEATS = 2;
	private CarType carType = CarType.SPORT;
	private static int count;
	static {
		count = 0;
	}
	{
		count++;
	}

	public SportCar() {

	}

	public SportCar(Color color) {

		super(color);
	}
	
public SportCar(Color color, double speed) {
		
		super(color,speed);
	}

public SportCar(Color color,int weight, double speed) {

	setColor(color); 
	setWeight(weight);
	setSpeed(speed);
}

public CarType getCarType() {
	return carType;
}

	@Override
	public void setColor(Color color) {
		super.setColor(color);
	}

	@Override
	public Color getColor() {
		return super.getColor();
	}

	@Override
	public double getSpeed() {
		return super.getSpeed();
	}

	@Override
	public void setSpeed(double speed) {
		super.setSpeed(speed);
	}

	public static int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "SportCar NUMBER_OF_SEATS=" + NUMBER_OF_SEATS + ", " + super.toString();
	}
	
	

}
