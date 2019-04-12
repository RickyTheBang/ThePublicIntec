package theGarageOp7.exceptions;

public class VehicleAlreadyInGarageException extends Exception {

	private static final long serialVersionUID = 1L;

	public VehicleAlreadyInGarageException() {
		super();
		
		
		}
	
	public VehicleAlreadyInGarageException(String message) {
		super(message);
	}
}
