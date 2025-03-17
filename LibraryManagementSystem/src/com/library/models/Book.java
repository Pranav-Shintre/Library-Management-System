package com.library.models;

public class Book {

	private String title;
	private String author;
	private String ISBN;
	private boolean isAvailable = true;

	public Book(String title, String author, String iSBN) {
		super();
		this.title = title;
		this.author = author;
		this.ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", isAvailable=" + isAvailable + "]";
	}
}
