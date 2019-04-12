package theGarageOp7.factory;

import theGarageOp7.garage.*;

import java.util.Random;

import theGarageOp7.enums.Color;

public class CarFactory {

	public Car BuildCar(CarType carType) {
		
		Random ran = new Random();
		Car car = null;
		Color color = Color.generateRandomColor();
		int weight = 500 + ran.nextInt(500);
		double speed = 0;
		car = new Cabriolet(color, weight, speed);
		
		switch(carType) {
		
		case CABRIOLET :
			car = new Cabriolet(color, weight, speed);
			
			break;
		case SUV :
			car = new SUV(color, weight, speed);
			
			break;
		case SPORT :
			car = new SportCar(color, weight, speed);
			
			break;
		case FAMILY :
			car = new FamilyCar(color, weight, speed);
			
			break;
		
		}
		
		

		return car;

	}

}
