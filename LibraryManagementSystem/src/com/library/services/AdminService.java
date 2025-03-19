package com.library.services;

import java.util.Scanner;

import com.library.models.Admin;
import com.library.models.Book;

public class AdminService {

	Scanner sc = new Scanner(System.in);

	private Book[] books = new Book[10]; // fixed size for the simplicity purpose
	private int bookCount = 5;

	public boolean login(String pwd) {
		return Admin.authenticate(pwd);
	}

	public void adminMenu() {
		while (true) {
			System.out.println("**********Admin Panel********** \n 1. Add a book \n 2. Remove a book \n 3. Logout");

			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter Book Title : ");
				String title = sc.next() + sc.nextLine();

				System.out.println("Enter Author Name : ");
				String author = sc.next() + sc.nextLine();

				System.out.println("Enter ISBN Number : ");
				String isbn = sc.next() + sc.nextLine();

				addBook(new Book(title, author, isbn));
				break;
			}

			case 2: {
				System.out.println("Enter ISBN Number to remove a book : ");
				String isbn = sc.next() + sc.nextLine();

				removeBook(isbn);
				break;
			}

			case 3: {
				System.out.println("Logging out...");
				return;
			}

			default:
				System.out.println("Invalid choice....");

			}

		}
	}

	public void addBook(Book book)
	{
		if(bookCount < books.length)
		{
			books[bookCount++] = book;
			System.out.println("Book added successfully...");
		}
		else {
			System.out.println("Library is full with books.");
		}
	}

	public void removeBook(String isbn)
	{
		for(int i=0; i<bookCount; i++)
		{
			if(books[i] != null && books[i].getISBN().equals(isbn))
			{
				books[i] = null;
				System.out.println("Book removed successfully...");
				return;
			}
		}
		
		System.out.println("Book not found..");
	}

}