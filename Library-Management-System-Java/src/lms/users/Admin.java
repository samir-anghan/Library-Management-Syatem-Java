/**
 * 
 */
package lms.users;

import java.util.ArrayList;
import java.util.List;

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
