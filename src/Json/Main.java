package Json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		serialize();
		deserialize();
	}

	private static void serialize() {
		ArrayList<Book> bookList = new ArrayList<Book>();

		// create books
		Book book1 = new Book("Harry Potter", "J. K. Rowling");
		Book book2 = new Book("Winnie the Pooh", "A. A. Milne");
		Book book3 = new Book("The Lord of the Rings", "J. R. R. Tolkien");

		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);

		// create bookstore
		Bookstore bookstore = new Bookstore("Steimatzky", "Tel Aviv");
		bookstore.setBooks(bookList);

		// Make JSON!!
		Gson gson = new Gson();
		String json = gson.toJson(bookstore);
		System.out.println(json);

		// Write JSON to file
		try {
			PrintWriter pw = new PrintWriter(new File("bookstore.json"));
			pw.write(json);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

	}

	private static void deserialize() {
		Gson gson = new Gson();

		// Option 1: from JSON String to Object
		// Bookstore bookstore = gson.fromJson("some json string",Bookstore.class);

		try {
			// Option 2: from JSON file to Object
			FileReader reader = new FileReader("bookstore.json");
			Bookstore bookstore = gson.fromJson(reader, Bookstore.class);
			System.out.println(bookstore);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
