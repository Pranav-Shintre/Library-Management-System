import java.util.*;

public class Library {

    // Maximum number of books in the library
    private static final int MAX_BOOKS = 100;

    // Array to store book details
    int[] bookIds = new int[MAX_BOOKS];
    String[] titles = new String[MAX_BOOKS];
    String[] authors = new String[MAX_BOOKS];
    boolean[] isAvailable = new boolean[MAX_BOOKS];
    int bookCount = 0;                  // Track the number of books in the library

    Scanner sc = new Scanner(System.in);

    // Method to add a book
    public void addBook()
    {
        if (bookCount >= MAX_BOOKS)
        {
            System.out.println("Library is full! Cannot add more books.");
            return;
        }

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();

        bookIds[bookCount] = bookId;
        titles[bookCount] = title;
        authors[bookCount] = author;
        isAvailable[bookCount] = true;
        bookCount++;

        System.out.println("Book added successfully!");
    }

    // Method to view all books
    public void viewBooks()
    {
        if (bookCount == 0)
        {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("\nBooks in the library:");
        for (int i = 0; i < bookCount; i++)
        {
            System.out.println("Book ID: " + bookIds[i] + ", Title: " + titles[i] + ", Author: " + authors[i] + ", Available: " + (isAvailable[i] ? "Yes" : "No"));
        }
    }

    // Method to borrow a book
    public void borrowBook()
    {
        System.out.print("Enter Book ID to Borrow: ");
        int bookId = sc.nextInt();

        for (int i = 0; i < bookCount; i++)
        {
            if (bookIds[i] == bookId)
            {
                if (isAvailable[i])
                {
                    isAvailable[i] = false;
                    System.out.println("You borrowed the book: " + titles[i]);
                } else {
                    System.out.println("Sorry, the book is currently unavailable.");
                }
                return;
            }
        }

        System.out.println("Book ID not found.");
    }

    // Method to return a book
    public void returnBook() {
        System.out.print("Enter Book ID to Return: ");
        int bookId = sc.nextInt();

        for (int i = 0; i < bookCount; i++)
        {
            if (bookIds[i] == bookId)
            {
                if (!isAvailable[i])
                {
                    isAvailable[i] = true;
                    System.out.println("You returned the book: " + titles[i]);
                } else {
                    System.out.println("The book was not borrowed.");
                }
                return;
            }
        }

        System.out.println("Book ID not found.");
    }

    // Menu for user interaction
    public void menu()
    {
        while (true)
        {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the library!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("Welcome to the Library Management System!");
        library.menu();
    }
}
