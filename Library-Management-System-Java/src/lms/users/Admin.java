/**
 * 
 */
package lms.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lms.books.Book;

/**
 * @author Samir
 *
 */
public class Admin extends RegisteredUser {

	public Admin(String username, int id, String firstName, String lastName, String password, String securityQuestion,
			String answer) {
		super(username, id, firstName, lastName, password, securityQuestion, answer);
	}

	ArrayList<User> userList;
	ArrayList<Book> bookList;

	public Admin() {

	}

	public void updateUser(User user) {
		Scanner in = new Scanner(System.in);
		System.out.println("\n>>>>>>LOG: Update user information:");
		
		System.out.println("User's first name is: " +user.getFirstName());
		System.out.println("Enter new first name:");
		String newFirstName = in.nextLine();
		
		System.out.println("User's last name is: " +user.getLastName());
		System.out.println("Enter new first name:");
		String newLastName = in.nextLine();
		
		System.out.println("User's password is: " +user.getPassword());
		System.out.println("Enter new first name:");
		String newPassword = in.nextLine();
		
		System.out.println("User's security question is: " +user.getSecurityQuestion());
		System.out.println("Enter new first name:");
		String newSecurityQuestion = in.nextLine();
		
		System.out.println("User's answers is: " +user.getAnswer());
		System.out.println("Enter new first name:");
		String newAnswer = in.nextLine();
		
		user.setFirstName(newFirstName);
		user.setLastName(newLastName);
		user.setPassword(newPassword);
		user.setSecurityQuestion(newSecurityQuestion);
		user.setAnswer(newAnswer);
		
		System.out.println("\n>>>>>>LOG: User information modified.");

	}

	public void deleteUser(User user) {

	}

	public void showAllUsers() {
		for (User usr : userList) {
			System.out.println(usr.getFirstName() + " " + usr.getLastName());
		}
	}

	public void searchUser(String searchKeyword) {
		
		List<User> searchResult = new ArrayList<User>();

		ArrayList<User> registeredUsers = userList;

		for (User registeredUser : registeredUsers) {
			String userFirstName = registeredUser.getFirstName();
			String userLastName = registeredUser.getLastName();
			
			if (userFirstName.toLowerCase().contains(searchKeyword.toLowerCase()) || (userLastName.toLowerCase().contains(searchKeyword.toLowerCase()))) {
				searchResult.add(registeredUser);
			}
		}

		if (!searchResult.isEmpty()) {
			System.out.println(">>>>>>LOG: Following users found based on your search keyword:");

			for (User usr : searchResult) {
				System.out.println(usr.getFirstName() + " " + usr.getLastName());
			}
		} else {
			System.out.println(">>>>>>LOG: No users found based on your search keyword.");
		}

	}

	public void addBook(Book book) {
		bookList.add(book);
	}

	public void deleteBook(Book book) {
		bookList.remove(book);
	}

	public void modifyBook(Book book) {
		Scanner in = new Scanner(System.in);
		System.out.println("\n>>>>>>LOG: Modify book information:");
		
		System.out.println("Book title is: " +book.getTitle());
		System.out.println("Enter new title:");
		String newTitle = in.nextLine();
		
		System.out.println("Book author is: " +book.getAuthor());
		System.out.println("Enter new title:");
		String newAuthor = in.nextLine();
		
		System.out.println("Book type is: " +book.getType());
		System.out.println("Enter new title:");
		String newType = in.nextLine();
		
		System.out.println("Number of Book pages is: " +book.getNop());
		System.out.println("Enter new title:");
		int newNop = in.nextInt();
		
		book.setTitle(newTitle);
		book.setAuthor(newAuthor);
		book.setType(newType);
		book.setNop(newNop);
		
		System.out.println("\n>>>>>>LOG: Book information modified.");
	}

	public void showBorrowedBooks() {
		for (Book book : bookList) {
			if (book.isOnLoan()) {
				System.out.println("Book id: " + book.getId());
				System.out.println("Book title: " + book.getTitle());
				System.out.println("Book author: " + book.getAuthor());
				System.out.println("Book type: " + book.getType());
				System.out.println("\n");
			}
		}
	}

	public void showReturnedBooks() {
		for (Book book : bookList) {
			if (!book.isOnLoan()) {
				System.out.println("Book id: " + book.getId());
				System.out.println("Book title: " + book.getTitle());
				System.out.println("Book author: " + book.getAuthor());
				System.out.println("Book type: " + book.getType());
				System.out.println("\n");
			}
		}
	}

}
