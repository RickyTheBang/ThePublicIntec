package theGarageOp7.garage;

import theGarageOp7.enums.Color;
import theGarageOp7.factory.CarType;

/**
 * A class to create a brand new Cabriolet
 * 
 * @author ericf
 *
 */

public class Cabriolet extends SportCar {
	private boolean openRoof;
	private CarType carType = CarType.CABRIOLET;
	private static int count;
	static {
		count = 0;
	}
	{
		count++;
	}

	/**
	 * Cabriolet constructor without argument
	 */

	public Cabriolet() {

	}

	/**
	 * 
	 * @param color
	 */

	public Cabriolet(Color color) {

		super(color);
	}

	/**
	 * Constructor
	 * @param color
	 * @param speed
	 */
	public Cabriolet(Color color, double speed) {

		super(color, speed);

	}

	/**
	 * Constructor
	 * @param color
	 * @param openRoof
	 */

	public Cabriolet(Color color, boolean openRoof) {

		super.setColor(color);
		this.openRoof = openRoof;
	}

	/**
	 * Constructor
	 * @param color
	 * @param speed
	 * @param openRoof
	 */
	
	public Cabriolet(Color color,int weight, double speed) {
		super(color,weight,speed);

	}
	public Cabriolet(Color color, double speed, boolean openRoof) {

		super(color, speed);
		this.openRoof = openRoof;
	}
	
	public CarType getCarType() {
		return carType;
	}

	/**
	 * 
	 */
	@Override
	public void setColor(Color color) {
		super.setColor(color);
	}

	@Override
	public Color getColor() {
		return super.getColor();
	}

	/**
	 * Sets the parameter openRoof
	 * @param value
	 */
	public void setOpenRoof(boolean value) {
		this.openRoof = value;
	}

	

	/**
	 * Gets the openRoof
	 * @return openRoof
	 */
	public boolean isOpenRoof() {
		return openRoof;
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
		return "Cabriolet: openRoof=" + openRoof + ", " + super.toString();
	}
	@Override
	@Deprecated
	public void finalize(){
		super.finalize();
		
		count--;
	}

}
