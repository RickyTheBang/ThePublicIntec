package be.intecbrussel.application;

import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.sellers.WaffleSeller.Waffle;
import be.intecbrussel.sellers.WaffleShop;

public class WaffleApp {
	
	public static void main(String[] args) {
		WaffleShop shop = new WaffleShop();
		Waffle w1 =shop.orderWaffle();
		Waffle w2 =shop.orderWaffle();
		Waffle w3 =shop.orderWaffle();
		Waffle w4 =shop.orderWaffle();
		Waffle w5 =shop.orderWaffle();
		Eatable[] waffles= new Eatable[] {w1,w2,w3,w4,w5};
		
		
		for(Eatable e : waffles) {
			e.eat();
		}
		
		System.out.println("Profit");
		System.out.println(shop.getProfit());
	}

}
