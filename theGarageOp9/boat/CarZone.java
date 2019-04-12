package theGarageOp9.boat;

import java.util.Arrays;

import theGarageOp9.exceptions.CarZoneFullException;
import theGarageOp9.exceptions.DockFullException;
import theGarageOp9.exceptions.GarageFullException;
import theGarageOp9.exceptions.VehicleAlreadyInCarZoneException;
import theGarageOp9.exceptions.VehicleAlreadyInDockException;
import theGarageOp9.exceptions.VehicleAlreadyInGarageException;
import theGarageOp9.garage.Car;
import theGarageOp9.interfaces.Movable;

public class CarZone {
	private int maxCar;
	private String zoneID;
	private Car[] cars=new Car[200];
	private int counter = 0;
	
	public CarZone() {
	
}
	
	
	public CarZone(int maxCar, String zoneID) {
		super();
		this.maxCar = maxCar;
		this.zoneID = zoneID;
	}


	public int getMaxCar() {
		return maxCar;
	}


	public void setMaxCar(int maxCar) {
		this.maxCar = maxCar;
	}


	public int getCounter() {
		return counter;
	}


	public String getZoneID() {
		return zoneID;
	}
	public void setZoneID(String zoneID) {
		this.zoneID = zoneID;
	}
	public Car[] getCars() {
		return cars;
	}
	public void setCars(Car[] cars) {
		this.cars = cars;
	}
	
	//*****************************************
	
	public void addVehicle(Car car) throws CarZoneFullException, VehicleAlreadyInCarZoneException {

		if (getSize() == maxCar) {
			throw new CarZoneFullException("The CarZone is full");
		}

		if (isVehiclePresent(car)) {
			throw new VehicleAlreadyInCarZoneException("The vehicule is already in the CarZone");
		}
		cars[nextFreePosition()] = car;
		counter++;

	}

	private boolean isVehiclePresent(Movable vehicule) {
		boolean present = false;
		for (int i = 0; i < maxCar; i++) {
			if (vehicule.equals(cars[i])) {
				present = true;
				i = maxCar;
			}
		}
		return present;
	}

	private int nextFreePosition() {
		int free = 0;
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] == null) {
				free = i;
				i = cars.length;
			}

		}
		return free;
	}

	public void removeVehicle(Movable vehicule) {
		int pos = 0;
		if (isVehiclePresent(vehicule)) {

			pos = getIndexVehicule(vehicule);
			cars[pos] = null;
			counter--;
		}
	}

	public int getIndexVehicule(Movable vehicule) {
		int pos = 0;
		for (int i = 0; i < cars.length; i++) {
			if (vehicule.equals(cars[i])) {
				pos = i;
			}
		}
		return pos;
	}

	public Movable getVehicleAtIndex(int index) {
		Movable vehicle = null;
		if (index < maxCar) {
			vehicle = cars[index];
		}
		return vehicle;
	}

	public void clear() {
		for (int i = 0; i < cars.length; i++) {
			cars[i] = null;
			counter = 0;
		}
	}

	public int getSize() {
		int size = 0;
		for (int i = 0; i < cars.length; i++) {
			if (!(cars[i] == null)) {
				size++;
			}
		}

		counter = size;

		return size;
	}

	public void printCarZone() {
		for (int i = 0; i < cars.length; i++) {
			if (!(cars[i] == null)) {
				System.out.println(cars[i]);
			}
		}
	}

	@Override
	public String toString() {
		return "CarZone [vehicules=" + Arrays.toString(cars) + ", counter=" + counter + "]";
	}
	
	

}
