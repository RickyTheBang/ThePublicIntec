package theGarageOp6.exceptions;

public class VehicleAlreadyInDockException extends Exception {

	private static final long serialVersionUID = 1L;

	public VehicleAlreadyInDockException() {
		super();
		
		
		}
	
	public VehicleAlreadyInDockException(String message) {
		super(message);
	}
}
