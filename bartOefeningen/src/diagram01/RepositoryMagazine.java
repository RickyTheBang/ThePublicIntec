package diagram01;

public class RepositoryMagazine {
	private Magazine[] magazines = new Magazine[200];
	
	
	//	public Magazine(String title, String text, int articles, int edition) {
	private Magazine mag0 = new Magazine("The Church", "The Pope is waiting for his man",12, 2019);
	private Magazine mag1 = new Magazine("This England", "Where is the Queen?",5, 2019);
	
	
	

	{
		fillMagazines();
	}

	public Magazine[] getMagazines() {
		return magazines;
	}

	private void fillMagazines() {
		magazines[0] = mag1;
	}

}
