package theGarageOp8.garage;

import theGarageOp8.enums.Color;
import theGarageOp8.factory.CarManufacturer;
import theGarageOp8.factory.CarType;
import theGarageOp8.factory.Country;


/**
* The Car class represents the general characteristics of a SUV
* 
* @author ERICF
*
*/
public class SUV extends Car{
	
	public final  static int NUMBER_OF_SEATS = 5;
	private CarType carType = CarType.SUV;
	private static int count;
	static {
		count = 0;
	}
	{
		count++;
	}
	
/**
 * Create a newly created FamilyCar without initializing any parameter
 */
	public SUV() {

	}
	
	public SUV(CarManufacturer manufacturer) {
		super(manufacturer);
	}
	
	/**
	 * Constructs a new FamilyCar by initializing the parameter color
	 * @param color
	 */
	
	public SUV(Color color,int weight, double speed) {

		setColor(color); 
		setWeight(weight);
		setSpeed(speed);
	}
	
	public SUV(Color color,int weight, double speed,Country country,CarManufacturer manufacturer) {

		super(color,weight,speed,country,manufacturer);
	}
	public SUV(Color color,int weight, double speed,Country country,CarManufacturer manufacturer, String model) {

		super(color,weight,speed,country,manufacturer,model);
	}
	public SUV(Color color) {

		super(color);
	}
	
	
	/**
	 * Constructs a new FamilyCar by initializing the parameters color and speed
	 * @param color
	 * @param speed
	 */
public SUV(Color color, double speed) {
		
		super(color,speed);
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
		return "SUV "+  getModel()  +": "+ super.toString() ;
	}
	

	
}
