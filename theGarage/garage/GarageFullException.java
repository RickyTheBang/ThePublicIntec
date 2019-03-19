package theGarage.garage;

public class GarageFullException extends Exception {

	private static final long serialVersionUID = 1L;

	public GarageFullException() {
		super();
	}
	
	public GarageFullException(String message) {
		super(message);
	}
}
