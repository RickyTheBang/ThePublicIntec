package theGarageOp6.boat;

import theGarageOp6.enums.*;
import theGarageOp6.harbor.*;
import theGarageOp6.interfaces.*;

public class ContainerBoat extends Boat{
	

	
	Container<Movable> container;
	private static int count;
	
	
	static {
		count = 0;
	}
	{
		count++;
	}
	
	
	
	public ContainerBoat(Color color) {
		setColor(color);
	}
	
	public Container<Movable> getContainer() {
		return container;
	}
	public void setContainer(Container<Movable> container) {
		this.container = container;
	}
	public static int getCount() {
		return count;
	}
	
	@Override
	public void dock() {
		System.out.println("The ContainerBoat is docked in a ContainerDock");
		
	}
}
