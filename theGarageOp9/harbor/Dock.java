package theGarageOp9.harbor;

import theGarageOp9.boat.*;
import theGarageOp9.interfaces.*;

public abstract class Dock {
	private  int Max = 50;
	private String country;
	private String name;
	

	//static private Boat dockedBoat;
	
	
	public Dock() {
		
	}
	
	public Dock(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	public static Boat getDockedBoat() {
//		return dockedBoat;
//	}
//	public static void setDockedBoat(Boat dockedBoat) {
//		Dock.dockedBoat = dockedBoat;
//	}
	public int getMax() {
		return Max;
	}

	public void setMax(int mAX) {
		this.Max = Max;
	}
	
	
	
	
	
	
	
	

	
	
	
	
	

}
