package theGarageOp6.boat;

import theGarageOp6.enums.Color;
import theGarageOp6.interfaces.Floatable;

public abstract class Boat implements Floatable {
	
	private int maxLoad =100*1000;
	private Color color = Color.WHITE;
	private double speed;
	private String city;
	private int number;
	private String callSign;
	private boolean canFloat;
	
	
	private static int count;
	static {
		count = 0;
	}
	{
		count++;
	}
	
	public Boat() {
	
	}

	public Boat(String city, int number) {
		this.city = city;
		this.number = number;
	}
	
	
	
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCallSign() {
		return callSign;
	}

	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

	public static int getCount() {
		return count;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	

	
	public int getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(int maxLoad) {
		this.maxLoad = maxLoad;
	}

	@Override
	public void accelerate(double value) {
		this.speed +=  value ;

	}

	@Override
	public void slowDown(double value) {
		double newSpeed = this.speed - value;
		if (newSpeed < 0) {
			newSpeed = 0;
		}
		this.speed = newSpeed;
	}
	
	
	
	

	public boolean isCanFloat() {
		return canFloat;
	}

	public void setCanFloat(boolean canFloat) {
		this.canFloat = canFloat;
	}

	@Override
	public double getSpeed() {		
		return speed;
	}
	



	

	@Override
	public void floatOnWater() {
		if(canFloat) {
			System.out.println("I can float on the water");
		}else {
			System.out.println("I cannot float on the water");
		}
		
	}



}
