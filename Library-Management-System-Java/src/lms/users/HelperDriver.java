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

	GuestUser guestUser = GuestUser.getInstance();
	User user = new User("user123", 1, "John", "Smith", "user123", "What is your favourite color?", "Red");
	Admin admin = new Admin("admin123", 1, "Tom", "Smith", "admin123", "What is your favourite color?", "Red");
	private ArrayList<User> userList = new ArrayList<User>();
	private ArrayList<Book> booksList = new ArrayList<Book>();

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public ArrayList<Book> getBooksList() {
		return booksList;
	}

	public void setBooksList(ArrayList<Book> booksList) {
		this.booksList = booksList;
	}

	public void initialSetup() {
		addInitialUsers();
		addInitialBooks();
	}

	private void addInitialUsers() {
		User user1 = new User("user123", 1, "John", "Smith", "user123", "What is your favourite color?", "Red");
		User user2 = new User("julius", 2, "Julius", "Charles", "user456", "What is your favourite color?", "Green");
		User user3 = new User("gina", 3, "Gina", "Cody", "gina123", "What is your favourite color?", "pink");
		User user4 = new User("tom123", 4, "Tom", "Smith", "tom123", "What is your favourite color?", "Black");
		User user5 = new User("jerry123", 5, "Jerry", "Asmar", "jerry123", "What is your favourite color?", "Red");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		
		admin.userList = this.userList;
	}

	private void addInitialBooks() {
		Book book1 = new Book("Model-Driven Development with Executable UML", "textbook", "Dragan Milicev", 250, 1,
				false);

		Book book2 = new Book("CLR via C# ", "textbook", "Jeffrey Richter", 300, 2, false);

		Book book3 = new Book("UML: A Beginner's Guide", "textbook", "Jason T. Roffv", 500, 3, false);

		Book book4 = new Book("The Alice Network", "novels", "Kate Quinn", 100, 4, false);

		Book book5 = new Book("Start Where You Are", "journal", "Meera Lee Patel", 100, 5, false);

		Book book6 = new Book("UML Modelling for Business Analysts: with Illustrated Examples", "textbook",
				"Mr. Abhishek Srivastava", 450, 6, false);

		Book book7 = new Book("Object Oriented Modeling and Design with UML", "textbook", "Ajit Singh", 400, 7, false);

		booksList.add(book1);
		booksList.add(book2);
		booksList.add(book3);
		booksList.add(book4);
		booksList.add(book5);
		booksList.add(book6);
		booksList.add(book7);

		user.booksList = this.booksList;
		admin.bookList = this.booksList;
		

	}

	private void showAllAvaiableBooks() {
		System.out.println(">>>>>>LOG: Following books are avaible at this moment:");

		for (Book book : booksList) {
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
	
	private User getUserFromId(int userId) {

		User userFromId = null;

		for (User user : userList) {
			if (user.getId() == userId) {
				userFromId = user;
				break;
			}
		}

		if (userFromId == null) {
			System.out.println("ERROR!!! Please enter a valid user id.");
		}

		return userFromId;
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

		System.out.println("\n---------------USER LOGIN---------------\n");

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
		System.out.println("Press 1 to search a book,");
		System.out.println("Press 2 to issue a book,");
		System.out.println("Press 3 to return a book");
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

		System.out.println("\n---------------ADMIN LOGIN---------------\n");

		System.out.println("Enter user name:");
		String userName = in.nextLine();

		System.out.println("Enter password:");
		String password = in.nextLine();

		boolean loginSuccess = user.login(userName, password, "admin");

		if (loginSuccess) {
			showAdminChoices();
		} else {
			return;
		}
	}

	private void showAdminChoices() {
		Scanner in = new Scanner(System.in);

		System.out.println("Select action:\n");
		System.out.println("Press 1 to show all returned books,");
		System.out.println("Press 2 to show all borrowed books,");
		System.out.println("Press 3 to add a book,");
		System.out.println("Press 4 to delete a book,");
		System.out.println("Press 5 to modify a book,");
		System.out.println("Press 6 to show all users,");
		System.out.println("Press 7 to search a user,");
		System.out.println("Press 8 to update a user,");
		System.out.println("Press 9 to delete a user,");

		int userChoice = in.nextInt();
		in.nextLine();

		switch (userChoice) {
		case 1:
			admin.showReturnedBooks();
			break;
			
		case 2:
			admin.showBorrowedBooks();
			break;
			
		case 3:
			System.out.println("Enter book title:");
			String bookName = in.nextLine();
			
			System.out.println("Enter book type:");
			String bookType = in.nextLine();
			
			System.out.println("Enter book author:");
			String bookAuthor = in.nextLine();
			
			System.out.println("Enter number of book pages:");
			int nop = in.nextInt();
			in.nextLine();
			
			System.out.println("Enter book id:");
			int id = in.nextInt();
			in.nextLine();
			
			Book newBook = new Book(bookName, bookType, bookAuthor, nop, id, false);
			admin.addBook(newBook);
			break;
		
		case 4:
			System.out.println("Enter book id to delete a book:");
			int deleteBookId = in.nextInt();
			Book bookToBeDeleted = getBookFromId(deleteBookId);

			if (bookToBeDeleted != null) {
				admin.deleteBook(bookToBeDeleted);
			}
			break;

		case 5:
			System.out.println("Enter book id to modify a book:");
			int modifyBookId = in.nextInt();
			Book bookToBeModified = getBookFromId(modifyBookId);

			if (bookToBeModified != null) {
				admin.modifyBook(bookToBeModified);
			}
			break;

			
		case 6:
			admin.showAllUsers();
			break;
			
		case 7:
			System.out.println("Enter user first name or last name keyword to search, e.g. John:");
			String searchKeyword = in.nextLine();
			admin.searchUser(searchKeyword);
			break;
			
		case 8:
			System.out.println("Enter user id to modify user information:");
			int modifyUserId = in.nextInt();
			User userToBeModified = getUserFromId(modifyUserId);

			if (userToBeModified != null) {
				admin.updateUser(userToBeModified);
			}
			break;
			
		case 9:
			System.out.println("Enter user id to delete a user:");
			int deleteUserId = in.nextInt();
			User userToBeDeleted = getUserFromId(deleteUserId);
			if (userToBeDeleted != null) {
				admin.deleteUser(userToBeDeleted);
			}
			break;
			
		default:
			System.out.println("\nINVALID CHOICE !!! TRY AGAIN !!!");
			break;

		}

	}

}
