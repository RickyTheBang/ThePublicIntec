package diagram01;

import java.util.Objects;

public class Magazine implements Readable{
	private String title;
	private String text;
	private int articles;
	private int edition;
	
	
	public Magazine() {

		
	}
	
	
	

	public Magazine(String title, String text, int articles, int edition) {

		this.title = title;
		this.text = text;
		this.articles = articles;
		this.edition = edition;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getText() {
		return text;
	}





	public void setText(String text) {
		this.text = text;
	}





	public int getArticles() {
		return articles;
	}





	public void setArticles(int articles) {
		this.articles = articles;
	}





	public int getEdition() {
		return edition;
	}





	public void setEdition(int edition) {
		this.edition = edition;
	}





	@Override
	public void read() {
		System.out.println(getClass().getSimpleName());
		System.out.println(getTitle());
		 text = getText();
		int words = 0;
		for (String w : text.split(" ")) {
			if ((words++) % 10 == 0) {
				System.out.println();}
			System.out.print(w + " ");
			
		}
		System.out.println();
		System.out.println();
	}
		
	
	
	






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + articles;
		result = prime * result + edition;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Magazine other = (Magazine) obj;
		if (articles != other.articles)
			return false;
		if (edition != other.edition)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}




	@Override
	public String toString() {
		String desc= "";
		desc = getClass().getSimpleName() + " - Title: " + getTitle() +" - First lines: " +getText().substring(0, 20) +"...";
		return desc;
		
	}	

}
