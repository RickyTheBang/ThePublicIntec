package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;
import static be.intecbrussel.eatables.Magnum.MagnumType;
import static be.intecbrussel.eatables.Cone.Flavor;


public interface IceCreamSeller extends Profitable {
	Cone orderCone(Flavor[] flavors);
	IceRocket orderIceRocket();
	Magnum orderMagnum(MagnumType magnumType);
	
}
