package theGarageOp6.garage;

import theGarageOp6.enums.Color;


/**
* The Car class represents the general characteristics of a FamilyCar
* 
* @author ERICF
*
*/
public class FamilyCar extends Car{
	
	public final  static int NUMBER_OF_SEATS = 5;
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
	public FamilyCar() {

	}
	
	/**
	 * Constructs a new FamilyCar by initializing the parameter color
	 * @param color
	 */

	public FamilyCar(Color color) {

		super(color);
	}
	
	
	/**
	 * Constructs a new FamilyCar by initializing the parameters color and speed
	 * @param color
	 * @param speed
	 */
public FamilyCar(Color color, double speed) {
		
		super(color,speed);
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
		return "FamilyCar : NUMBER_OF_SEATS=" + NUMBER_OF_SEATS + ", " + super.toString() ;
	}
	

	
}
