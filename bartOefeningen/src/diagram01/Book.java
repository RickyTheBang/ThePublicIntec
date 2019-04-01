package diagram01;

import java.util.Objects;

public class Book implements Readable {
	String title;
	String text;
	int chapters;

	public Book() {
	}

	public Book(String title, String text, int chapters) {
		this.title = title;
		this.text = text;
		this.chapters = chapters;
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

	public int getChapters() {
		return chapters;
	}

	public void setChapters(int chapters) {
		this.chapters = chapters;
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
		result = prime * result + chapters;
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
		Book other = (Book) obj;
		if (chapters != other.chapters)
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
