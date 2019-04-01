package diagram01;

public class NewsPaperPublisher implements Publisher {

	private String name;
	private Subscriber[] subscribers = new Subscriber[100];
	private NewsPaper[] papersInventory = new NewsPaper[400];
	
	public NewsPaperPublisher() {		
}
	

	public NewsPaperPublisher(String name) {
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
				NewsPaper newsPaper = (NewsPaper) readable;
				if (paperExists(newsPaper)) {
				} else {
					for (int index = 0; index < papersInventory.length; index++) {
						if (papersInventory[index] == null) {
							papersInventory[index] = newsPaper;
							index = papersInventory.length;
						}
					}				
				}
			}
		}
		private boolean paperExists(NewsPaper newsPaper) {
			for (NewsPaper r : papersInventory) {
				if (r == null) {
					return false;
				}
				if (r.equals(newsPaper)) {
					return true;
				}
			}
			return false;
		}
	}
