package theGarageOp7.app;

import java.util.Random;

import theGarageOp7.garage.Car;
import theGarageOp7.factory.CarFactory;
import theGarageOp7.factory.CarType;

public class GarageAppOpdracht7 {
	public static void main(String[] args) {
		
		CarFactory carFactory = new CarFactory();
		
		Random ran = new Random();
		
		CarType[] carTypes =CarType.values();
		
		for(int i = 0; i<20; i++){
			CarType carType = carTypes[ran.nextInt(3)];		
			Car car = carFactory.BuildCar(carType);
			System.out.println(car);
		}
		
	
		}
		 
	}

