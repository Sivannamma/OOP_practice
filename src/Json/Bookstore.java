package Json;
import java.util.ArrayList;

public class Bookstore
{	
    private String storeName;
    private String location;
    private ArrayList<Book> books;
    
    public Bookstore(String name, String location) 
    {
		this.storeName = name;
		this.location = location;
	}
    
    public void setBooks(ArrayList<Book> bookList) {
        this.books = bookList;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    
    @Override
	public String toString() {
		return "Bookstore: name: " + storeName + ", location: " + location + ", books:\n" + books;
	}
}