package diagram01;

public class MagazinePublisher implements Publisher {

	private String name;
	private Subscriber[] subscribers = new Subscriber[100];
	private Magazine[] magazineInventory = new Magazine[400];
	
	public MagazinePublisher() {		
}
	

	public MagazinePublisher(String name) {
			this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subscriber[] getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Subscriber[] subscribers) {
		this.subscribers = subscribers;
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
					addPaper(readable);
					sub.update(readable);
				}

			}

		}

		private void addPaper(Readable readable) {
			if (readable instanceof Book) {
				Magazine magazine = (Magazine) readable;
				if (magazineExists(magazine)) {
				} else {
					for (int index = 0; index < magazineInventory.length; index++) {
						if (magazineInventory[index] == null) {
							magazineInventory[index] = magazine;
							index = magazineInventory.length;
						}
					}				
				}
			}
		}
		private boolean magazineExists(Magazine magazine) {
			for (Magazine r : magazineInventory) {
				if (r == null) {
					return false;
				}
				if (r.equals(magazine)) {
					return true;
				}
			}
			return false;
		}
	}
