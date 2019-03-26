package be.intecbrussel.sellers;

public class NoMoreIceCreamException extends Exception{

	private static final long serialVersionUID = 1892153613758503730L;
	
	NoMoreIceCreamException(){
		super();
	}
	
NoMoreIceCreamException(String message){
		super(message);
	}

}
