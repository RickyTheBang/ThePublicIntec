package theGarageOp6.harbor;

import theGarageOp6.boat.*;

public class containerDock extends Dock {
	static private ContainerBoat boat;
	
	

	public containerDock(int max) {
		setMax(max);
		
	}



	public static ContainerBoat getBoat() {
		return boat;
	}



	public static void setBoat(ContainerBoat boat) {
		containerDock.boat = boat;
	}

	
	
	
	

}
