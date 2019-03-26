package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;
import be.intecbrussel.eatables.Cone.Flavor;
import be.intecbrussel.eatables.Magnum.MagnumType;

/**
 * The class IceCreamCar takes care of all the business concerning selling ice
 * creams in a car
 * 
 * @author ERICF
 *
 */

public class IceCreamCar implements IceCreamSeller {
	private PriceList priceList;
	private Stock stock;
	private double profit = 0;
	private boolean flagCone = true;
	private boolean flagRocket = true;
	private boolean flagMag = true;

	/**
	 * Constructor with two parameters
	 * 
	 * @param priceList
	 * @param stock
	 */

	public IceCreamCar(PriceList priceList, Stock stock) {
		this.priceList = priceList;
		this.stock = stock;
	}

	/**
	 * Check if the NoMoreIceCreamException has been already catched in the
	 * orderCone method
	 * 
	 * @return flagCone
	 */

	public boolean isFlagCone() {
		return flagCone;
	}

	/**
	 * set the value of flagCone
	 * 
	 * @param flagCone
	 */

	public void setFlagCone(boolean flagCone) {
		this.flagCone = flagCone;
	}

	/**
	 * Check if the NoMoreIceCreamException has been already catched in the
	 * orderIceRocket method
	 * 
	 * @return flagCone
	 */
	public boolean isFlagRocket() {
		return flagRocket;
	}

	/**
	 * set the value of flagRocket
	 * 
	 * @param flagRocket
	 */

	public void setFlagRocket(boolean flagRocket) {
		this.flagRocket = flagRocket;
	}

	/**
	 * Check if the NoMoreIceCreamException has been already catched in the
	 * orderMagnum method
	 * 
	 * @return flagCone
	 */
	public boolean isFlagMag() {
		return flagMag;
	}

	/**
	 * set the value of flagMag
	 * 
	 * @param flagMag
	 */

	public void setFlagMag(boolean flagMag) {
		this.flagMag = flagMag;
	}

	/**
	 * Returns the profit generated by the selling of ice creams
	 */

	@Override
	public double getProfit() {
		return profit;
	}

	/**
	 * create a new cone with all the flavors asked
	 */

	@Override
	public Cone orderCone(Flavor[] flavors) {
		Cone result = null;
		try {
			result = prepareCone(flavors);
		} catch (NoMoreIceCreamException e) {
			if (isFlagCone()) {
				System.out.println(e.getMessage());
				setFlagCone(false);
			}

		}
		return result;
	}

	/**
	 * prepare a new cone with all the flavors asked throws NoMoreIceCreamException
	 */

	private Cone prepareCone(Flavor[] flavors) throws NoMoreIceCreamException {
		Cone orderedCone = new Cone(flavors);

		int stockConeAvailable = stock.getCones() - 1;
		int stockBallAvailable = stock.getBalls() - flavors.length;

		if (stockConeAvailable < 0) {
			throw new NoMoreIceCreamException("No more cones are available!");
		}
		if (stockBallAvailable < 0) {
			throw new NoMoreIceCreamException("No more balls are available!");
		}
		this.profit += (priceList.getBallPrice() * flavors.length);
		stock.setCones(stockConeAvailable);
		stock.setBalls(stockBallAvailable);
		return orderedCone;
	}

	/**
	 * create a new IceRocket
	 */
	@Override
	public IceRocket orderIceRocket() {
		IceRocket result = null;
		try {
			result = prepareIceRocket();
		} catch (NoMoreIceCreamException e) {

			if (isFlagRocket()) {
				System.out.println(e.getMessage());
				setFlagRocket(false);
			}
		}
		return result;
	}

	/**
	 * prepare a IceRocket throws NoMoreIceCreamException
	 */
	private IceRocket prepareIceRocket() throws NoMoreIceCreamException {
		IceRocket iceRocket = new IceRocket();

		int stockAvailable = stock.getIceRocket() - 1;

		if (stockAvailable < 0) {
			throw new NoMoreIceCreamException("No more IceRockets are available!");
		}
		this.profit += priceList.getRocketPrice();
		stock.setIceRocket(stockAvailable);

		return iceRocket;
	}

	/**
	 * create Magnum of a specific magnumType
	 */
	@Override
	public Magnum orderMagnum(MagnumType magnumType) {
		Magnum result = null;
		try {
			result = prepareMagnum(magnumType);
		} catch (NoMoreIceCreamException e) {

			if (isFlagMag()) {
				System.out.println(e.getMessage());
				setFlagMag(false);
			}
		}
		return result;
	}

	/**
	 * prepare a Magnum of a specific magnumType throws NoMoreIceCreamException
	 */
	private Magnum prepareMagnum(MagnumType magnumType) throws NoMoreIceCreamException {
		Magnum orderedMagnum = new Magnum(magnumType);

		int stockAvailable = stock.getMagni() - 1;
		if (stockAvailable < 0) {
			throw new NoMoreIceCreamException("No more magnums are available!");
		}
		this.profit += priceList.getMagnumPrice(magnumType);
		stock.setMagni(stockAvailable);
		return orderedMagnum;
	}

	/**
	 * Returns the name of the class, the priceList and the profit
	 */

	@Override
	public String toString() {
		return "IceCreamCar [priceList=" + priceList + ", stock=" + stock + ", profit=" + profit + "]";
	}

}
