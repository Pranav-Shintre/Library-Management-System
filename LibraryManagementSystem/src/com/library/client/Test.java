package com.library.client;

import java.util.Scanner;

import com.library.models.User;
import com.library.services.AdminService;
import com.library.services.LibraryService;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LibraryService ls = new LibraryService();
		AdminService as = new AdminService();

		while (true) {
			System.out.println("**********Library Management System*********** \n 1. Borrow a book \n 2. Return a book \n 3. Admin Login(Add/Remove Books) \n 4. Exit");
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter your user name : ");
				String userName = sc.nextLine();

				System.out.println("Enter your userId : ");
				String userId = sc.nextLine();

				User user = new User(userName, userId);
				ls.displayBooks();

				System.out.println("Enter Book ISBN to borrow a book : ");
				String isbn = sc.nextLine();

				ls.borrowBook(user, isbn);
				break;
			}

			case 2: {
				System.out.println("Enter your userId : ");
				String userId = sc.nextLine();

				ls.returnBook(userId);
				break;
			}

			case 3: {
				System.out.println("Enter the admin password : ");
				String passwd = sc.nextLine();

				if (as.login(passwd))
					as.adminMenu(sc);
				else
					System.out.println("Incorrect password..");

				break;
			}

			case 4: {
				System.out.println("Thank You For Using Library Management System");
				sc.close();
				return;
			}

			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
