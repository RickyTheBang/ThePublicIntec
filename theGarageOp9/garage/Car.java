package theGarageOp9.garage;

import java.util.Random;
import java.util.UUID;

import theGarageOp9.enums.Color;
import theGarageOp9.interfaces.Movable;
import theGarageOp9.interfaces.Paintable;

/**
 * The Car class represents the general characteristics of a car
 * 
 * @author ERICF
 *
 */

public abstract class Car implements Movable, Paintable {
	public static int NUMBER_OF_WHEELS = 4;
	private Color color = Color.WHITE;;
	private double speed;
	private int weight = 1000;
	private String parkingSpot;
	private final int chassisID = UUID.randomUUID().hashCode();
	private static int count;
	static {
		count = 0;
	}
	{
		count++;
	}

	/**
	 * Constructor without parameter
	 */
	public Car() {

	}

	/**
	 * Constructor
	 * 
	 * @param color
	 */

	public Car(Color color) {
		if (color == null) {
			this.color = Color.WHITE;
		}

		this.color = color;
	}

	/**
	 * Constructor
	 * 
	 * @param color
	 * @param speed
	 */
	public Car(Color color, double speed) {

		this.color = color;
		this.speed = speed;
	}

	/**
	 * 
	 * @return color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Set the color of the car
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * 
	 * @return speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * Set the speed of the car
	 * 
	 * @param speed
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * Set the weight of the car
	 * 
	 * @return weight
	 */

	public int getWeight() {
		return weight;
	}

	/**
	 * 
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * count is the number of the created cars
	 * 
	 * @return count
	 */
	public static int getCount() {
		return count;
	}

	/**
	 * Set the parkingSpot of the car
	 * 
	 * @return ParkingSpot
	 */

	public String getParkingSpot() {
		return parkingSpot;
	}

	public int getChassisID() {
		return chassisID;
	}

	/**
	 * 
	 * @param parkingSpot
	 */
	public void setParkingSpot(String parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	/**
	 * increase the speed of the car
	 * 
	 * @param value
	 */
	@Override
	public void accelerate(double value) {
		this.speed += value;

	}

	/**
	 * decrease the speed of the car
	 * 
	 * @param value
	 */
	@Override
	public void slowDown(double value) {
		double newSpeed = this.speed - value;
		if (newSpeed < 0) {
			newSpeed = 0;
		}
		this.speed = newSpeed;
	}

	/**
	 * change the color of the car
	 * 
	 * @param color
	 */
	@Override
	public void rePaint(Color color) {
		this.color = color;

	}

	/**
	 * Returns a string representation of the attributes of the specified car.
	 */
	@Override
	public String toString() {
		return "NUMBER_OF_WHEELS=" + NUMBER_OF_WHEELS + ", color= " + color + ", speed= " + (int) speed + " "
				+ hashCode();

	}

	/**
	 * Returns a hash code based on the attributes of the specified car.
	 */

	@Override
	public int hashCode() {

		int result = 1;
		final int prime = 31;
		result = prime * result + getChassisID();
		result = prime * result + getWeight();
		result = prime * result + (int) getSpeed();
		result = prime * result + getClass().getSimpleName().hashCode();
		int[] rgbThis = this.color.getRgb();

		for (int i = 0; i < rgbThis.length; i++) {

			result = prime * result + rgbThis[i];

		}
		return result;
	}

	/**
	 * Returns true if the two specified cars are equal to one another.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}
		Car other = (Car) obj;

		int[] rgbThis = this.color.getRgb();
		int[] rgbOther = other.color.getRgb();
		boolean colorEqual = true;

		for (int i = 0; i < rgbThis.length; i++) {

			if (rgbThis[i] != rgbOther[i]) {
				colorEqual = false;
				i = rgbThis.length;
			}
		}

		if (colorEqual && this.getSpeed() == other.getSpeed() && this.getChassisID() == other.getChassisID()
				&& this.getWeight() == other.getWeight() && this.getParkingSpot().equals(other.getParkingSpot())) {
			return true;
		}

		return false;

	}

	/**
	 * Generate a new car with random values for the different parameters
	 * 
	 * @return Car
	 */


	@Override
	@Deprecated
	public void finalize() {

		count--;
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
	
	public static double generateSpeed() {
		double speed;
		Random ran = new Random();
		speed= ran.nextInt(120)+5;
				
		
		
		return speed;
	}

}
