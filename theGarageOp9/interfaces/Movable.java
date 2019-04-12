package theGarageOp9.interfaces;



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
