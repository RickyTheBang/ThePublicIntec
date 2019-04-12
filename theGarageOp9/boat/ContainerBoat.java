package theGarageOp9.boat;

import theGarageOp6.garage.Car;
import theGarageOp9.enums.*;
import theGarageOp9.harbor.*;
import theGarageOp9.interfaces.*;
import theGarageOp9.zoo.Animal;

public class ContainerBoat extends Boat {

	private Container<?>[] containers = new Container<?>[4];

	private Container<Object> container1 = new Container<Object>(new Object[100]);
	private Container<Object> container2 = new Container<Object>(new Animal[100]);
	private Container<Object> container3 = new Container<Object>(new Number[100]);
	private Container<Object> container4 = new Container<Object>(new Car[100]);

	private static int count;

	{

		containers[0] = container1;
		containers[1] = container2;
		containers[2] = container3;
		containers[3] = container4;
	}

	static {
		count = 0;
	}
	{
		count++;
	}

	public ContainerBoat(Color color) {
		setColor(color);
	}

	public Container<?>[] getContainers() {
		return containers;
	}

	public void setContainers(Container<?>[] containers) {
		this.containers = containers;
	}

	public static int getCount() {
		return count;
	}

	@Override
	public void dock() {
		System.out.println("The ContainerBoat is docked in a ContainerDock");

	}
}
