package theGarageOp8.app;

import java.util.Random;

import theGarageOp8.garage.Car;
import theGarageOp8.factory.CarFactory;
import theGarageOp8.factory.CarFactoryGenerator;
import theGarageOp8.factory.CarType;

public class GarageAppOpdracht8 {
	public static void main(String[] args) {
		
		
		
		
		
		for(int i = 0; i<20; i++){
			CarFactory carFactory = CarFactoryGenerator.generateCarFactory();
			
			Random ran = new Random();
			
			CarType[] carTypes =CarType.values();
			CarType carType = carTypes[ran.nextInt(3)];		
			Car car = carFactory.BuildCar(carType);
			System.out.println(car);
		}
		
	
		}
		 
	}

