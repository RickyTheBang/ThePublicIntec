package theGarageOp6.harbor;

public class Harbor {
	private  String name;
	private String country;
	private Dock[] docks;
	
	
	public Harbor() {
		
	}
	
	public Harbor(String name) {
	
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Dock[] getDocks() {
		return docks;
	}
	public void setDocks(Dock[] docks) {
		this.docks = docks;
	}
	
	

}
