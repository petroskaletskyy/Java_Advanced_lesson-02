package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private int id;
	private String bookName;
	private String bookDescription;
	private double price;
	private String isbn;

	public Book(int id, String bookName, String bookDescription, double price, String isbn) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.price = price;
		this.isbn = isbn;
	}

	public Book(String bookName, String bookDescription, double price, String isbn) {
		super();
		this.bookName = bookName;
		this.bookDescription = bookDescription;
		this.price = price;
		this.isbn = isbn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return id + " --> Назва книги - " + "\"" + bookName + "\"" + ", опис книги - " + "\"" + bookDescription + "\"" + ", ціна - " + price
				+ ", isbn - " + isbn;
	}
	
	public static List<Book> createDefaultData() {
		List<Book> booklList = new ArrayList<>();
		booklList.add(new Book("Щоденник слабака.Книга 1", "Мова: українська", 125.00, "978-966-948-239-6"));
		booklList.add(new Book("Щоденник слабака.33 нещастя.Книга 8", "Мова: українська", 130.00, "978-966-948-170-2"));
		booklList.add(new Book("Щоденник слабака. Книга 7. Третій зайвий", "Мова: українська", 125.00, "978-617-7535-73-6"));
		booklList.add(new Book("Нічне кіно", "Мова: українська", 208.00, "978-966-917-290-7"));
		booklList.add(new Book("Токийский гуль. Книга 1", "Мова: російська", 248.00, "978-5-389-15107-9"));
		return booklList;
	} 

}
