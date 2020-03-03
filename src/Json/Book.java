package Json;

public class Book {
	private String name;
	private String author;

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "\nBook: name: " + name + ", author: " + author + "\n";
	}
}