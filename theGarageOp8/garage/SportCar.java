package theGarageOp8.garage;

import theGarageOp8.enums.Color;
import theGarageOp8.factory.CarManufacturer;
import theGarageOp8.factory.CarType;
import theGarageOp8.factory.Country;

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

	public SportCar(CarManufacturer manufacturer) {
		super(manufacturer);
	}
	public SportCar(Color color) {

		super(color);
	}
	
public SportCar(Color color, double speed) {
		
		super(color,speed);
	}

public SportCar(Color color,int weight, double speed,Country country,CarManufacturer manufacturer) {

	super(color,weight,speed,country,manufacturer);
}

public SportCar(Color color,int weight, double speed,Country country,CarManufacturer manufacturer, String model) {

	super(color,weight,speed,country,manufacturer,model);
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
		return "SportCar "+  getModel()  +": "+ super.toString() ;
	}
	
	

}
