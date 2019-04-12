package theGarageOp6.app;

import theGarageOp6.boat.CarBoat;
import theGarageOp6.boat.CarZone;
import theGarageOp6.enums.Color;
import theGarageOp6.exceptions.*;
import theGarageOp6.garage.*;
import theGarageOp6.harbor.CarDock;
import theGarageOp6.interfaces.Movable;

public class GarageAppOpdracht6 {
	public static void main(String[] args) {
		boolean fullFlagGarage = true;
		boolean fullFlag = true;
		boolean loadFlag = true;

		CarDock carDock = new CarDock();
		
	CarZone[] carZoneDock = carDock.getDockParkeerPlaats();	
	Garage garage = carDock.getDockGarage();
//		for(CarZone c : carZoneDock) {
//			System.out.print(c.getZoneID()+ " ");
//		}
		
		for (int i = 0; i < 759; i++) {

			Car car = null;
			car = Car.generateRandomCar();

			car.setColor(Color.generateRandomColor());
			car.setSpeed(Car.generateSpeed());
			try {
				garage.addVehicle(car);
			} catch (GarageFullException e1) {
				if(fullFlagGarage) {
					System.out.println(e1.getMessage());
					fullFlagGarage = false;
				}
				
				
				try {
					carDock.addCar(car);

				} catch (DockFullException e) {
					if(fullFlag) {
						System.out.println(e.getMessage());
						fullFlag = false;
					}
					
				} catch (VehicleAlreadyInDockException e) {
					if(loadFlag) {
						System.out.println(e.getMessage());
						loadFlag = false;
					}
					
				}
				
			} catch (VehicleAlreadyInGarageException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	
		}
		System.out.println("Size of the garage: " + garage.getSize());
		System.out.println("Size of the dock: " + carDock.getSize());
		carDock.printCarZoneSize();
		System.out.println("Number of Car: " + Car.getCount());
		System.out.println("Number of FamilyCar: " + FamilyCar.getCount());
		System.out.println("Number of SportCar: " + SportCar.getCount());
		System.out.println("Number of Cabriolet: " + Cabriolet.getCount());
		//carDock.printDock();
		
		
		/*
		int count = 1;
		for (int i = 0; i < carZoneDock.length; i++) {
			CarZone carZone = carZoneDock[i];
			Car[] cars = carZone.getCars();
			for (int j = 0; j < carZoneDock[i].getMaxCar(); j++) {
				if(cars[j]!=null) {
					System.out.println(count++ + " "+cars[j]);
				}
				
				}

			}
			*/
		}
		 
	}

