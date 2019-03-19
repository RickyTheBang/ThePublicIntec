package theGarage.app;

import theGarage.enums.Color;
//import garage.*;
import theGarage.garage.*;

public class GarageAppOpdracht1 {
	public static void main(String[] args) {
		Garage garage = new Garage();

		Cabriolet cc1 = new Cabriolet(Color.BLACK, 250);
		Cabriolet cc2 = new Cabriolet(Color.BLACK, 230);
		Cabriolet cc3 = new Cabriolet(Color.BLACK, 185);

		SportCar sc1 = new SportCar(Color.generateRandomColor(), 150);
		SportCar sc2 = new SportCar(Color.GREEN, 170);
		SportCar sc3 = new SportCar(Color.WHITE, 210);

		FamilyCar fc1 = new FamilyCar(Color.RED, 70);
		FamilyCar fc2 = new FamilyCar(Color.BLUE, 80);
		FamilyCar fc3 = new FamilyCar(Color.BLUE, 90);
		FamilyCar fc4 = new FamilyCar(Color.BLUE, 100);

		try {

			garage.addVehicle(cc1);
			garage.addVehicle(cc2);
			garage.addVehicle(cc3);
			garage.addVehicle(sc1);
			garage.addVehicle(sc2);
			garage.addVehicle(sc3);
			garage.addVehicle(fc1);
			garage.addVehicle(fc2);
			garage.addVehicle(fc3);
			garage.addVehicle(fc4);

		} catch (GarageFullException e) {
			System.out.println();
			System.out.println(e.getMessage());
		} catch (VehicleAlreadyInGarageException e) {
			System.out.println(e.getMessage());
		}
		garage.printGarage();
	}

}
