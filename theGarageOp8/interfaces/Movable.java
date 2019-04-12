package theGarageOp8.interfaces;

import java.util.Random;

import theGarageOp8.garage.Cabriolet;
import theGarageOp8.garage.Car;
import theGarageOp8.garage.FamilyCar;
import theGarageOp8.garage.SportCar;

/**
 * The Interface applies to all objects moving int the space : cars, boats, planes,...
 * 
 * @author ericf
 *
 */

public interface Movable {
	/**
	 * 
	 * @param value
	 */
	void accelerate(double value);
	void slowDown(double value);
	double getSpeed();
	
	/**
	 * This static method generate randomly any kind of Movable object
	 *
	 */
	

}
