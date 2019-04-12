package theGarageOp8.garage;

import java.util.Arrays;
import java.util.Objects;

import theGarageOp8.enums.Color;
import theGarageOp8.exceptions.GarageFullException;
import theGarageOp8.exceptions.VehicleAlreadyInGarageException;
import theGarageOp8.interfaces.Movable;

public class ProtoGarage {
	

	public static final int MAX = 80;
	Movable[] vehicules = new Movable[MAX];
	private int counter = 0;

	public void addVehicle(Movable vehicule) throws GarageFullException, VehicleAlreadyInGarageException {

		if (getSize() == MAX) {
			throw new GarageFullException("The garage is full");
		}

		if (isVehiclePresent(vehicule)) {
			throw new VehicleAlreadyInGarageException("The vehicule is already in the garage");
		}
		vehicules[nextFreePosition()] = vehicule;
		counter++;

	}

	private boolean isVehiclePresent(Movable vehicule) {
		boolean present = false;
		for (int i = 0; i < MAX; i++) {
			if (vehicule.equals(vehicules[i])) {
				present = true;
				i = MAX;
			}
		}
		return present;
	}

	private int nextFreePosition() {
		int free = 0;
		for (int i = 0; i < vehicules.length; i++) {
			if (vehicules[i] == null) {
				free = i;
			}

		}
		return free;
	}

	public void removeVehicle(Movable vehicule) {
		int pos = 0;
		if (isVehiclePresent(vehicule)) {

			pos = getIndexVehicule(vehicule);
			vehicules[pos] = null;
			counter--;
		}
	}

	public int getIndexVehicule(Movable vehicule) {
		int pos = 0;
		for (int i = 0; i < vehicules.length; i++) {
			if (vehicule.equals(vehicules[i])) {
				pos = i;
			}
		}
		return pos;
	}

	public Movable getVehicleAtIndex(int index) {
		Movable vehicle = null;
		if (index < MAX) {
			vehicle = vehicules[index];
		}
		return vehicle;
	}

	public void clear() {
		for (int i = 0; i < vehicules.length; i++) {
			vehicules[i] = null;
			counter = 0;
		}
	}

	public int getSize() {
		int size = 0;
		for (int i = 0; i < vehicules.length; i++) {
			if (!(vehicules[i] == null)) {
				size++;
			}
		}

		counter = size;

		return size;
	}

	public void printGarage() {
		for (int i = 0; i < vehicules.length; i++) {
			if (!(vehicules[i] == null)) {
				System.out.println(vehicules[i]);
			}
		}
	}

	@Override
	public String toString() {
		return "Garage [vehicules=" + Arrays.toString(vehicules) + ", counter=" + counter + "]";
	}
	
	public class ProtoCar extends Car {
		boolean prototype = true;
		int amount = 0;

		public ProtoCar() {
			setColor(Color.WHITE);
			setSpeed(120);

		}
		
		public ProtoCar(int amount) {
			setColor(Color.WHITE);
			setSpeed(120);
			this.amount = amount;

		}

		@Override
		public String toString() {
			return "prototype=" + prototype + ", amount=" + amount + " " + super.toString() ;
		}

	}

}
