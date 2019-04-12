package theGarageOp8.exceptions;

public class DockFullException extends Exception {

private static final long serialVersionUID = 432921442449677027L;

	public DockFullException() {
		super();
	}
	
	public DockFullException(String message) {
		super(message);
	}
}
