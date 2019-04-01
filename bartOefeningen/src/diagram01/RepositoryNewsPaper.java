package diagram01;

import java.time.LocalDate;



public class RepositoryNewsPaper {
	private NewsPaper[] papers = new NewsPaper[200];
	
	private NewsPaper paper0 = new NewsPaper(1,"The Times", "A murder in London",48,  LocalDate.of(2019, 03, 25));
	private NewsPaper paper1 = new NewsPaper(1,"Daily Mail", "Brexit? yes or no?",20,  LocalDate.of(2019, 03, 29));
	
	public NewsPaper[] getPapers() {
		return papers;
	}

	{
		fillNewsPapers();
	}



	private void fillNewsPapers() {
		papers[0] = paper0;
		papers[1] = paper1;
	}

}
