package diagram01;

public class BookClub implements Subscriber, Publisher {

	private String name;
	private Book[] books= new Book[500];
	private Subscriber[] members = new Subscriber[500];

	public BookClub() {

	}

	public BookClub(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void update(Readable readable) {
		if (checkIfBook( readable)) {
			Book book = (Book) readable;
			if (bookExists(book)) {
			} else {
				for (int index = 0; index < books.length; index++) {
					if (books[index] == null) {
						books[index] = book;
						index = books.length;
					}
				}
				
				 publish(readable);
			}

		}

	}
	
	private boolean checkIfBook(Readable book) {
		return book instanceof Book;
	}

	private boolean bookExists(Book book) {
		for (Book r : books) {
			if (r == null) {
				return false;
			}
			if (r.equals(book)) {
				return true;
			}
		}
		return false;
	}
	
	public void removeBook(Book book) {

		for (int index = 0; index < books.length; index++) {
			if (books[index].equals(book)) {
				books[index] = null;
				index = books.length;
			}
		}

	}

	@Override
	public void subscribe(Subscriber subscriber) {
		if (subscriberExists(subscriber)) {
		} else {
		for (int i = 0; i < members.length; i++) {
			if (members[i] == null) {
				members[i] = subscriber;
				i = members.length;
			}
		}
		}
	}
	
	private boolean subscriberExists(Subscriber member) {
		for (Subscriber r : members) {
			if (r == null) {
				return false;
			}
			if (r.equals(member)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void unsubscribe(Subscriber subscriber) {
		for (int i = 0; i < members.length; i++) {
			if (members[i].equals(subscriber)) {
				members[i] = null;
				i = members.length;
			}
		}

	}

	@Override
	public void publish(Readable readable) {
		for (Subscriber sub : members) {
			if (sub != null) {
				
				sub.update(readable);
			}

		}

	}

}
