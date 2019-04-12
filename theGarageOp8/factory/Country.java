package theGarageOp8.factory;

import java.util.Random;

import theGarageOp8.enums.Color;

public enum Country {
	BE,UK,US,NL,FR;
	
	
	public static Country generateRandomCountry() {

		Country[] values = Country.values();
		Country country = null;
		Random ran = new Random();
		int pos = ran.nextInt(Country.values().length);
		country = values[pos];
		return country;
	}

}
