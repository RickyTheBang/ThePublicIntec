package theGarageOp9.harbor;

public class Container<T> {
	
	//T[] cont = new <String>[10];
	
	T[] cont;
	public Container() {	
		
	}
	
	public Container(T[] cont) {	
		this.cont = cont;
	}

	public T[] getCont() {
		return cont;
	}

	public void setCont(T[] cont) {
		this.cont = cont;
	}

	
	
	

}
