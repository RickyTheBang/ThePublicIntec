package theGarageOp7.exceptions;

public class CarZoneFullException extends Exception {

private static final long serialVersionUID = 432921442449677027L;

	public CarZoneFullException() {
		super();
	}
	
	public CarZoneFullException(String message) {
		super(message);
	}
}
