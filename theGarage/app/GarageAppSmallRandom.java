package theGarage.app;

import theGarage.enums.Color;
import theGarage.garage.Cabriolet;
import theGarage.garage.Car;
import theGarage.garage.FamilyCar;
import theGarage.garage.Garage;
import theGarage.garage.GarageFullException;
import theGarage.garage.SportCar;
import theGarage.garage.VehicleAlreadyInGarageException;
import theGarage.interfaces.Movable;

public class GarageAppSmallRandom {

	public static final double MAX_SPEED = 70;
	public static void main(String[] args) {
		Garage garage = new Garage();

		//Vul de garage totdat die vol is en vang de exception op. 
		//Zorg voor een gebruiksvriendelijke boodschap
		for (int i = 0; i < 110; i++) {
			Movable vehicle;
			Color randomColor = createRandomColor();
			if (i % 3 == 0) {
				vehicle = new SportCar(randomColor);
			} else if (i % 2 == 0) {
				vehicle = new FamilyCar(randomColor);
			} else {
				vehicle = new Cabriolet(randomColor, true);
			}
			double value = createRandomAcceleration(MAX_SPEED);
			vehicle.accelerate(value);
			//try {
				
			//} catch () {
				
			//}
		}
		
		//Druk af hoeveel van elk type voertuig er gemaakt zijn
		System.out.println("Car count = " + Car.getCount());
		System.out.println("FamilyCar count = " + FamilyCar.getCount());
		System.out.println("Cabriolet count = " + Cabriolet.getCount());
		System.out.println("SportCar count = " + SportCar.getCount());
		System.out.println("garage Size = " + garage.getSize());
		System.out.println("Garage = " + garage.toString());
		
		//Verminder van alle voertuigen de snelheid totdat ze stil staan
		for (int i = 0; i < garage.getSize(); i++) {
			Movable vehicle = garage.getVehicleAtIndex(i);
			if (vehicle != null) {
				vehicle.slowDown(vehicle.getSpeed());
			}
		}
		System.out.println("Garage = " + garage.toString());
	}

	private static double createRandomAcceleration(double maxSpeed) {
		return Math.random() * MAX_SPEED;
	}

	private static Color createRandomColor() {
		Color[] colors = Color.values();
		int index = (int) Math.round(Math.random() * colors.length - 1);
		index = index < 0 ? 0 : index;
		return colors[index];
	}
		

}