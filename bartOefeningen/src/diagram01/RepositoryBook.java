package diagram01;

public class RepositoryBook {
	private Book[] books = new Book[200];
	
	private Book book0 = new Book("The Hound of the Baskervilles",
			"Has a savage beast been unleashed from hell to " + "torment the last of the Baskervilles," 

			, 4);
	
	private Book book1 = new Book("The Stranger",
			"Meursault learns of the death of his mother, "
			+ "who has been living in a retirement home."
			

			, 6);
	
	
	public Book[] getBooks() {
		return books;
	}

	{
		fillBooks();
	}



	private void fillBooks() {
		books[0] = book0;
		books[1] = book1;
	}

}
