package com.library.services;

import com.library.models.Book;
import com.library.models.User;

public class LibraryService {

	private Book[] books = {
			new Book("Clean Code", "Robert Martin", "101"),
			new Book("Java : The Complete Reference", "Herbert Schildt", "102"),
			new Book("Making India Awesome", "Chetan Bhagat", "103"),
			new Book("Broken Wings", "Sarojini Naidu", "104"),
			new Book("Idols", "Sunil Gavaskar", "105")
	};
	
	public void displayBooks()
	{
		System.out.println("Available books : ");
		
		for(Book book:books)
		{
			System.out.println(book);
		}
	}

	public void borrowBook(User user, String ISBN)
	{
		for(Book book:books)
		{
			if(book.getISBN().equals(ISBN) && book.isAvailable())
			{
				user.setBorrowedBook(book);
				book.setAvailable(false);
				System.out.println("Book borrowed successfully....");
				return;
			}
		}
		
		System.out.println("Book not available");
	}
	
	public void returnBook(String userId)
	{
		for(Book book : books)
		{
			if(!book.isAvailable())
			{
				book.setAvailable(true);
				System.out.println("Book returned successfully....");
				return;
			}
		}
		
		System.out.println("No book found to return..");
	}
	
	
}
