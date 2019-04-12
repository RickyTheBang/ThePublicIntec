package theGarageOp8.factory;

public class CarFactoryGenerator {
	
	public static CarFactory generateCarFactory(){
		CarFactory carFactory = null;
		
		CarManufacturer carManufacturer = CarManufacturer.generateRandomCarManufacturer();
		switch(carManufacturer) {
		case AUDI:
			carFactory = new CarFactoryAudi();
			break;
		case RENAULT:
			carFactory = new CarFactoryRenault();
			break;
		case TESLA:
			carFactory = new CarFactoryTesla();
			break;
		case PORSCHE:
			carFactory = new CarFactoryPorsche();
			break;
		}
		
		
		
		return  carFactory;
	}

}
