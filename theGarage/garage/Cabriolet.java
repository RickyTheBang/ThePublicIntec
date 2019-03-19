package theGarage.garage;

import theGarage.enums.Color;

/**
 * A class to create a brand new Cabriolet
 * @author ericf
 *
 */

public class Cabriolet extends SportCar {
	private boolean openRoof;
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
	 * 
	 * @param color
	 * @param speed
	 */
public Cabriolet(Color color, double speed) {
		
		super(color,speed);

	}

/**
 * 
 * @param color
 * @param openRoof
 */
	
public Cabriolet(Color color,  boolean openRoof) {
		
		super.setColor(color);
		this.openRoof = openRoof;
	}
	/**
	 * 
	 * @param color
	 * @param speed
	 * @param openRoof
	 */
public Cabriolet(Color color, double speed, boolean openRoof) {
		
		super(color,speed);
		this.openRoof = openRoof;
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
	 * 
	 */
	public void openRoof() {
		this.openRoof = true;
	}
	
	public void closeRoof() {
		this.openRoof = false;
	}
	
	public boolean isRoofOpen() {
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
	
	

}
