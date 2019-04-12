package theGarageOp9.app;


import theGarageOp9.boat.ContainerBoat;
import theGarageOp9.enums.Color;
import theGarageOp9.harbor.Container;
import theGarageOp9.zoo.Dog;


public class GarageAppOpdracht9 {
	public static void main(String[] args) {
		
	
	
	ContainerBoat containerBoat =  new ContainerBoat(Color.BLACK);
	
	Container<?>[] containers = containerBoat.getContainers();
	
	Object[] c1Object =  containers[0].getCont();
	Object[] c1Animal =  containers[1].getCont();
	c1Object[0] = new Object();
	Dog d1 =(Dog) (c1Animal[0]=new Dog("Rex"));
	System.out.println(c1Object[0]);
	System.out.println(d1.getName());
	
		 
	}

}