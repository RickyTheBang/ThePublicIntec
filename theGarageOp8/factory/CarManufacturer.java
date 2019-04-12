package theGarageOp8.factory;

import java.util.Random;

public enum CarManufacturer {
TESLA,AUDI,RENAULT,PORSCHE;
	
	public static CarManufacturer generateRandomCarManufacturer() {

		CarManufacturer[] values = CarManufacturer.values();
		CarManufacturer carManufacturer = null;
		Random ran = new Random();
		int pos = ran.nextInt(CarManufacturer.values().length);
		carManufacturer = values[pos];
		return carManufacturer;
	}
}
