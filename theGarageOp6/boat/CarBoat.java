package theGarageOp6.boat;


import theGarageOp6.exceptions.BoatFullException;
import theGarageOp6.exceptions.BoatOverloadException;
import theGarageOp6.garage.*;

public class CarBoat extends Boat {

	private int maxVehicule = 100;
	private Car[] cars = new Car[maxVehicule];
	private int carCounter = 0;
	private double totalCarWeight = 0;

	public CarBoat() {

	}

	public CarBoat( int maxVehicule, int maxLoad) {
		setMaxLoad(maxLoad);
		setMaxVehicule(maxVehicule);
	}

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	public int getMaxVehicule() {
		return maxVehicule;
	}

	public void setMaxVehicule(int maxVehicule) {
		this.maxVehicule = maxVehicule;
	}

	public int getCarCounter() {
		return carCounter;
	}

	public double getTotalCarWeight() {
		return totalCarWeight;
	}

	public void addVehicle(Car car) throws BoatFullException, BoatOverloadException {

		if (getCarCounter() > maxVehicule - 1) {
			throw new BoatFullException("The boat is full of cars");
		}

		if (totalCarWeight > getMaxLoad()) {
			throw new BoatOverloadException("The boat is overloaded");
		}

		cars[carCounter++] = car;
		totalCarWeight += car.getWeight();

	}
	
	//***********************************************************
	
	
	
	
	//*********************************************************

	@Override
	public void dock() {
		System.out.println("The CarBoat is docked in a CarDock");

	}
	
	public void printGarage() {
		for (int i = 0; i < cars.length; i++) {
			if (!(cars[i] == null)) {
				System.out.println(cars[i]);
			}
		}
	}

}
