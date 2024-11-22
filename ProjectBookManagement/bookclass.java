package ProjectBookManagement;

import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class bookclass {
	private ArrayList<Book> books;
	private int numBooks;
	private String dataFilePath;
	private String title;
	private String author;
	private double price;
	private int quantity;
	private int bookId;
	
	public bookclass(int capacity, String dataFilePath) {
        books = new ArrayList<Book>(capacity);
        this.dataFilePath = dataFilePath;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(int bookId, String title, String author, double price, int quantity) {
        Book book = new Book(bookId, title, author, price, quantity);
        books.add(book);
    }
}