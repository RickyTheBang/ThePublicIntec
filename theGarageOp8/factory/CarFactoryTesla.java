package theGarageOp8.factory;

import theGarageOp8.garage.*;

import java.util.Random;

import theGarageOp8.enums.Color;

public class CarFactoryTesla extends CarFactory {

	public Car BuildCar(CarType carType) {

		Random ran = new Random();
		Car car = null;
		Color color = Color.generateRandomColor();
		int weight = 500 + ran.nextInt(500);
		double speed = 0;
		Country country = Country.generateRandomCountry();
		CarManufacturer manufacturer = CarManufacturer.TESLA;

		switch (carType) {

		case CABRIOLET:
			car = new Cabriolet(color, weight, speed, country, manufacturer,"model S");

			break;
		case SUV:
			car = new SUV(color, weight, speed, country, manufacturer,"model y");

			break;
		case SPORT:
			car = new SportCar(color, weight, speed, country, manufacturer,"model x");

			break;
		case FAMILY:
			car = new FamilyCar(color, weight, speed, country, manufacturer,"model 3");

			break;

		}
return car;
}
}