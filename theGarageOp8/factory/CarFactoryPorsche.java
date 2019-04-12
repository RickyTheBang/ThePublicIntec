package theGarageOp8.factory;

import theGarageOp8.garage.*;

import java.util.Random;

import theGarageOp8.enums.Color;

public class CarFactoryPorsche extends CarFactory {

	public Car BuildCar(CarType carType)  {

		Random ran = new Random();
		Car car = null;
		Color color = Color.generateRandomColor();
		int weight = 500 + ran.nextInt(500);
		double speed = 0;
		Country country = Country.generateRandomCountry();
		CarManufacturer manufacturer = CarManufacturer.PORSCHE;

		switch (carType) {

		case CABRIOLET:
			car = new Cabriolet(color, weight, speed, country, manufacturer);

			break;
		case SUV:
			car = new SUV(color, weight, speed, country, manufacturer);

			break;
		case SPORT:
			car = new SportCar(color, weight, speed, country, manufacturer);

			break;
		case FAMILY:
			car = new FamilyCar(color, weight, speed, country, manufacturer);

			break;

		}

		return car;

	}

}
