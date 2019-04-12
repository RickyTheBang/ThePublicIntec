package theGarageOp9.harbor;



import theGarageOp9.boat.*;
import theGarageOp9.exceptions.DockFullException;

import theGarageOp9.exceptions.VehicleAlreadyInDockException;

import theGarageOp9.garage.Car;
import theGarageOp9.garage.Garage;


public class CarDock extends Dock {

	private final int Max = 1200;
	private final int MaxZone = 200;
	private String country;
	private CarBoat boat;
	private Garage dockGarage;
	private CarZone[] dockParkeerPlaats = new CarZone[(Max / MaxZone)];
	private final int MAX_SPEED = 50;
	private int counter = 0;

	{
		for (int i = 0; i < dockParkeerPlaats.length; i++) {

			char zone = (char) (65 + i);
			String zoneString = String.valueOf(zone);
			CarZone carZone = new CarZone(200, zoneString.toString());
			dockParkeerPlaats[i] = carZone;
			carZone.setMaxCar(MaxZone);
			dockGarage =new Garage();
		}
	}

	public CarDock() {

	}

	public CarDock(String name) {
		setName(name);
	}

	public int getMax() {
		return Max;
	}

	public int getMaxZone() {
		return MaxZone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getCounter() {
		return counter;
	}

	public Garage getDockGarage() {
		return dockGarage;
	}

	public void setDockGarage(Garage dockGarage) {
		this.dockGarage = dockGarage;
	}

	public CarZone[] getDockParkeerPlaats() {
		return dockParkeerPlaats;
	}

//	public void setDockParkeerPlaats(CarZone[] dockParkeerPlaats) {
//		this.dockParkeerPlaats = dockParkeerPlaats;
//	}
	public int getMAX_SPEED() {
		return MAX_SPEED;
	}

	public void addCar(Car car) throws DockFullException, VehicleAlreadyInDockException {

		if (getSize() == Max) {
			throw new DockFullException("The Dock is full");
		}

		if (isCarPresent(car)) {
			throw new VehicleAlreadyInDockException("The vehicule is already in the dock");
		}
		int pos = nextFreePosition();
		if (pos < Max) {
			int i = pos / MaxZone;
			int j = pos %MaxZone;

			CarZone carZone = dockParkeerPlaats[i];
			Car[] cars = carZone.getCars();

			cars[j] = car;
			counter++;
		}

	}

	private boolean isCarPresent(Car car) {
		boolean present = false;

		for (int i = 0; i < dockParkeerPlaats.length; i++) {
			CarZone carZone = dockParkeerPlaats[i];
			Car[] cars = carZone.getCars();
			for (int j = 0; j < cars.length; j++) {
				if (car.equals(cars[j])) {
					present = true;
					i = dockParkeerPlaats.length;
					j =cars.length;
				}

			}
		}

		return present;
	}

	public int nextFreePosition() {
		int free = 0;
		for (int i = 0; i < dockParkeerPlaats.length; i++) {
			CarZone carZone = dockParkeerPlaats[i];
			Car[] cars = carZone.getCars();
			for (int j = 0; j < cars.length; j++) {
				if (cars[j] == null) {
					free = ( MaxZone) * i + j;
					i =  dockParkeerPlaats.length;
					j =  cars.length;
					
				}

			}
		}

		return free;
	}

	public void removeCar(Car car) {
		int pos = 0;
		if (isCarPresent(car)) {

			pos = getIndexCar(car);
			int i = pos / (MaxZone-1);
			int j = pos % (MaxZone-1);
			if (pos < Max) {
				CarZone carZone = dockParkeerPlaats[i];
				Car[] cars = carZone.getCars();

				cars[j] = null;
				counter--;
			}

		}
	}

	public int getIndexCar(Car car) {

		int pos = 0;
		for (int i = 0; i < dockParkeerPlaats.length; i++) {
			CarZone carZone = dockParkeerPlaats[i];
			Car[] cars = carZone.getCars();
			for (int j = 0; j < cars.length; j++) {
				if (car.equals(cars[j])) {
					pos = (Max / MaxZone) * i + j;
				}

			}
		}

		return pos;
	}

	public Car getCarAtIndex(int index) {
		Car car = null;

		int i = index / MaxZone;
		int j = index % MaxZone;
		if (index < Max) {
			CarZone carZone = dockParkeerPlaats[i];
			Car[] cars = carZone.getCars();

			car = cars[j];
		}
		return car;
	}

	public void clear() {

		for (int i = 0; i < dockParkeerPlaats.length; i++) {
			CarZone carZone = dockParkeerPlaats[i];
			Car[] cars = carZone.getCars();
			for (int j = 0; j < cars.length; j++) {
				cars[j] = null;
				counter = 0;
			}

		}
	}

	public int getSize() {

		int size = 0;
		for (int i = 0; i < dockParkeerPlaats.length; i++) {
			CarZone carZone = dockParkeerPlaats[i];
			Car[] cars = carZone.getCars();
			for (int j = 0; j <cars.length; j++) {
				if (!(cars[j] == null)) {
					size++;
				}
			}
		}
		counter = size;

		return size;
	}

	public void printDock() {
		for (int i = 0; i < dockParkeerPlaats.length; i++) {
			CarZone carZone = dockParkeerPlaats[i];
			Car[] cars = carZone.getCars();
			for (int j = 0; j < dockParkeerPlaats[i].getMaxCar(); j++) {
				if (!(cars[i] == null)) {
					System.out.println(cars[i]);
				}

			}

		}
	}
	
	public void printCarZoneSize() {
		for (int i = 0; i < dockParkeerPlaats.length; i++) {
			CarZone carZone = dockParkeerPlaats[i];
			
			System.out.println(carZone.getZoneID() + ": " +carZone.getSize());
		

		}
	}
	/*
	 * @Override public String toString() { return "Garage [vehicules=" +
	 * Arrays.toString(vehicules) + ", counter=" + counter + "]"; }
	 */
}
