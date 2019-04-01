package diagram01;



public class ReadCornerApp {

	public static void main(String[] args) {
		RepositoryBook bookRepo = new RepositoryBook();
		RepositoryNewsPaper paperRepo = new RepositoryNewsPaper();
		RepositoryMagazine magRepo = new RepositoryMagazine();
		Book book0 = bookRepo.getBooks()[0];
		Book book1 = bookRepo.getBooks()[1];
		NewsPaper paper0 = paperRepo.getPapers()[0];
		NewsPaper paper1 = paperRepo.getPapers()[1];
		Magazine mag0 = magRepo.getMagazines()[0];
		Magazine mag1 = magRepo.getMagazines()[1];
		
		Person joe = new Person("John");
		
		MagazinePublisher stuart = new MagazinePublisher();
		NewsPaperPublisher london = new NewsPaperPublisher();

		BookPublisher penguin = new BookPublisher("Penguin");
		
		
		
		BookClub fnac = new BookClub("fnac");
		penguin.subscribe(fnac);
		fnac.subscribe(joe);
		stuart.subscribe(joe);
		london.subscribe(joe);
		
		
		penguin.publish(book0);
		penguin.publish(book1);
		stuart.publish(paper0);
		stuart.publish(paper1);
		london.publish(mag0);
		london.publish(mag1);
		joe.readAll();

//		penguin.publish(book1);
//		joe.readAll();
//		for (Book b : penguin.getBooksInventory()) {
//			if (b != null) {
//				System.out.println(b);
//			}
//
//		}
	}
}
