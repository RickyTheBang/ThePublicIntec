package diagram01;

public class BookPublisher implements Publisher {
	private String name;
	private Subscriber[] subscribers = new Subscriber[100];
	private Book[] booksInventory = new Book[400];

	public BookPublisher() {

	}

	public BookPublisher(String name) {
		this.name = name;
	}

	public Book[] getBooksInventory() {
		return booksInventory;
	}

	@Override
	public void subscribe(Subscriber subscriber) {
		for (int i = 0; i < subscribers.length; i++) {
			if (subscribers[i] == null) {
				subscribers[i] = subscriber;
				i = subscribers.length;
			}
		}

	}

	@Override
	public void unsubscribe(Subscriber subscriber) {
		for (int i = 0; i < subscribers.length; i++) {
			if (subscribers[i].equals(subscriber)) {
				subscribers[i] = null;
				i = subscribers.length;
			}
		}

	}

	@Override
	public void publish(Readable readable) {
		for (Subscriber sub : subscribers) {
			if (sub != null) {
				addBook(readable);
				sub.update(readable);
			}

		}

	}

	private void addBook(Readable readable) {
		if (readable instanceof Book) {
			Book book = (Book) readable;
			if (bookExists(book)) {
			} else {
				for (int index = 0; index < booksInventory.length; index++) {
					if (booksInventory[index] == null) {
						booksInventory[index] = book;
						index = booksInventory.length;
					}
				}				
			}
		}
	}
	private boolean bookExists(Book book) {
		for (Book r : booksInventory) {
			if (r == null) {
				return false;
			}
			if (r.equals(book)) {
				return true;
			}
		}
		return false;
	}
}
