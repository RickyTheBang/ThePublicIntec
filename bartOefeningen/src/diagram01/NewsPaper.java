package diagram01;

import java.time.LocalDate;
import java.util.Objects;

public class NewsPaper implements Readable {
	private int categories;
	private String title;
	private String text;
	private int pages;
	private LocalDate datePublished;

	public NewsPaper() {

	}

	public NewsPaper(int categories, String title, String text, int pages, LocalDate datePublished) {

		this.categories = categories;
		this.title = title;
		this.text = text;
		this.pages = pages;
		this.datePublished = datePublished;
	}

	public int getCategories() {
		return categories;
	}

	public void setCategories(int categories) {
		this.categories = categories;
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

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public LocalDate getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}

	@Override
	public void read() {
		System.out.println(getClass().getSimpleName());
		System.out.println(getTitle());
		text = getText();
		int words = 0;
		for (String w : text.split(" ")) {
			if ((words++) % 10 == 0) {
				System.out.println();
			}
			System.out.print(w + " ");

		}
		System.out.println();
		System.out.println();
	}
	
	
	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categories;
		result = prime * result + ((datePublished == null) ? 0 : datePublished.hashCode());
		result = prime * result + pages;
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
		NewsPaper other = (NewsPaper) obj;
		if (categories != other.categories)
			return false;
		if (datePublished == null) {
			if (other.datePublished != null)
				return false;
		} else if (!datePublished.equals(other.datePublished))
			return false;
		if (pages != other.pages)
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
		String desc = "";
		desc = getClass().getSimpleName() + " - Title: " + getTitle() + " - First lines: " + getText().substring(0, 20)
				+ "...";
		return desc;

	}

}
