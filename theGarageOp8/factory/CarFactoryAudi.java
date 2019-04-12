package theGarageOp8.factory;

import theGarageOp8.garage.*;

import java.util.Random;

import theGarageOp8.enums.Color;

public class CarFactoryAudi extends CarFactory {

	public Car BuildCar(CarType carType)  {

		Random ran = new Random();
		Car car = null;
		Color color = Color.generateRandomColor();
		int weight = 500 + ran.nextInt(500);
		double speed = 0;
		Country country = Country.generateRandomCountry();
		CarManufacturer manufacturer = CarManufacturer.AUDI;

		switch (carType) {

		case CABRIOLET:
			car = new Cabriolet(color, weight, speed, country, manufacturer,"a3");

			break;
		case SUV:
			car = new SUV(color, weight, speed, country, manufacturer,"q7");

			break;
		case SPORT:
			car = new SportCar(color, weight, speed, country, manufacturer,"Rs");

			break;
		case FAMILY:
			car = new FamilyCar(color, weight, speed, country, manufacturer,"a6");

			break;

		}

		return car;

	}

}
