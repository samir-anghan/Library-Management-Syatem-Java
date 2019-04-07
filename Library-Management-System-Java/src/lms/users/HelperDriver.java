/**
 * 
 */
package lms.users;

import java.util.ArrayList;
import java.util.Scanner;

import lms.books.Book;

/**
 * @author Samir
 *
 */
public class HelperDriver {

	private static HelperDriver TheUniqueHelperDriver;

	public static HelperDriver getInstance() {
		if (HelperDriver.TheUniqueHelperDriver == null) {
			HelperDriver.TheUniqueHelperDriver = new HelperDriver();
		}
		return HelperDriver.TheUniqueHelperDriver;
	}

	// To prevent creating instance
	private void HelperDriver() {

	}

	GuestUser guestUser = GuestUser.getInstance();
	User user = User.getInstance();
	private ArrayList<Book> booksList = new ArrayList<Book>();
	
	
	public ArrayList<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(ArrayList<Book> booksList) {
		this.booksList = booksList;
	}

	public void initialSetup() {
		addInitialBooks();
	}

	private void addInitialBooks() {
		Book book1 = new Book("Model-Driven Development with Executable UML", 
				"textbook", 
				"Dragan Milicev", 
				250, 
				1, 
				false);
		
		Book book2 = new Book("CLR via C# ", 
				"textbook", 
				"Jeffrey Richter", 
				300, 
				2, 
				false);
		
		Book book3 = new Book("UML: A Beginner's Guide", 
				"textbook", 
				"Jason T. Roffv", 
				500, 
				3, 
				false);
		
		Book book4 = new Book("The Alice Network", 
				"novels", 
				"Kate Quinn", 
				100, 
				4, 
				false);
		
		Book book5 = new Book("Start Where You Are", 
				"journal", 
				"Meera Lee Patel", 
				100, 
				5, 
				false);
		
		Book book6 = new Book("UML Modelling for Business Analysts: with Illustrated Examples", 
				"textbook", 
				"Mr. Abhishek Srivastava", 
				450, 
				6, 
				false);
		
		Book book7 = new Book("Object Oriented Modeling and Design with UML", 
				"textbook", 
				"Ajit Singh", 
				400, 
				7, 
				false);
		
		booksList.add(book1);
		booksList.add(book2);
		booksList.add(book3);
		booksList.add(book4);
		booksList.add(book5);
		booksList.add(book6);
		booksList.add(book7);
		
		user.booksList = this.booksList;

	}
	
	private void showAllAvaiableBooks() {
		System.out.println(">>>>>>LOG: Following books are avaible at this moment:");
		
		for (Book book: booksList) {
			System.out.println("Id: " + book.getId());
			System.out.println("Title: " + book.getTitle());
			System.out.println("Type: " + book.getType());
			System.out.println("Author: " + book.getAuthor());
			System.out.println("\n");
		}
	}
	
	private Book getBookFromId(int bookId) {
		
		Book bookFromId = null;
		
		for (Book book : booksList) {
			if (book.getId() == bookId) {
				bookFromId = book;
				break;
			}
		}
		
		if (bookFromId == null) {
			System.out.println("ERROR!!! Please enter a valid book id.");
		}
		
		return bookFromId;
	}
	
	public void processGuestUser() {
		Scanner in = new Scanner(System.in);
		System.out.println("Select action:\n");
		System.out.println("Press 1 for sign up,");
		System.out.println("Press 2 to search a book:");

		int userChoice = in.nextInt();

		switch (userChoice) {
		case 1:
			guestUser.signUp();
			break;

		case 2:
			guestUser.searchBook();
			break;

		default:
			System.out.println("\nINVALID CHOICE !!! \nRun again to use the library management system.");
			break;
		}
	}

	public void processUser() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("\n---------------LOGIN---------------\n");
		
		System.out.println("Enter user name:");
		String userName = in.nextLine();
		
		System.out.println("Enter password:");
		String password = in.nextLine();
		
		boolean loginSuccess = user.login(userName, password, "user");
		
		if (loginSuccess) {
			showUserChoices();
		} else {
			return;
		}
	}
	
	private void showUserChoices() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Select action:\n");
		System.out.println("Press 1 to search a book,\n");
		System.out.println("Press 2 to issue a book,\n");
		System.out.println("Press 3 to return a book,\n");
		System.out.println("Press 4 to pay penalty:");

		int userChoice = in.nextInt();
		in.nextLine();

		switch (userChoice) {
		case 1:
			System.out.println("Enter book name keyword to search, e.g. UML:");
			String searchKeyword = in.nextLine();
			user.searchBook(searchKeyword);
			break;

		case 2:
			showAllAvaiableBooks();
			System.out.println("Enter book id to issue a book:");
			int bookId = in.nextInt();
			Book bookToBeIssued = getBookFromId(bookId);
			
			if (bookToBeIssued != null) {
				user.issueBook(bookToBeIssued);
			}
			break;

		case 3:
			System.out.println("Enter book id to return a book:");
			int returnBookId = in.nextInt();
			Book bookToBeReturned = getBookFromId(returnBookId);
			
			if (bookToBeReturned != null) {
				user.returnBook(bookToBeReturned);
			}
			break;

		case 4:
			user.payPenalty();
			break;

		default:
			System.out.println("\nINVALID CHOICE !!! TRY AGAIN !!!");
			break;
		}
	}

	public void processAdmin() {
		Scanner in = new Scanner(System.in);
		System.out.println("Select action:\n");
		System.out.println("Press 1 for sign up,\n");
		System.out.println("Press 2 to search a book:");

		int userChoice = in.nextInt();

		switch (userChoice) {
		case 1:
			guestUser.signUp();
			break;

		case 2:
			guestUser.searchBook();
			break;

		default:
			System.out.println("\nINVALID CHOICE !!! TRY AGAIN !!!");
			break;
		}
	}

}
