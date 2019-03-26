package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.eatables.Cone.Flavor;
import be.intecbrussel.eatables.Magnum.MagnumType;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;

public class IceCreamAppV2 {

	public static void main(String[] args) {

		IceCreamCar car = new IceCreamCar(new PriceList(10, 11, 12), new Stock(10, 2,10, 15));

		Cone cone1 = car.orderCone(new Flavor[] { Flavor.BANANA, Flavor.CHOCOLATE });
		Cone cone2 = car.orderCone(new Flavor[] { Flavor.VANILLA });
		Cone cone3 = car.orderCone(new Flavor[] { Flavor.VANILLA, Flavor.LEMON, Flavor.MOKKA, Flavor.PISTACHE });
		IceRocket iceRocket = car.orderIceRocket();
		Magnum magnum1 = car.orderMagnum(MagnumType.MILKCHOCOLATE);
		Magnum magnum2 = car.orderMagnum(MagnumType.ROMANTICSTRAWBERRIES);

		Eatable[] iceCreams = new Eatable[] { cone1, cone2, cone3, iceRocket, magnum1, magnum2 };
		
		for(int i = 0;i < iceCreams.length;i++) {
			if(iceCreams[i]!=null) {
				iceCreams[i].eat();
			}
		}

		System.out.println("Profit");
		System.out.println(car.getProfit());

	}

}
