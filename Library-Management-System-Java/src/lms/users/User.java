/**
 * 
 */
package lms.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lms.books.Book;

/**
 * @author Samir
 *
 */
public class User extends RegisteredUser {
	
	private static User TheUniqueUser;

	public static User getInstance() {
		if (User.TheUniqueUser == null) {
			User.TheUniqueUser = new User();
		}
		return User.TheUniqueUser;
	}
	
	// To prevent creating instance
	private User() {
		
	}
	
	private double penaltyDueAmount;
	public ArrayList<Book> booksList;
	
	public double getPenaltyDueAmount() {
		return penaltyDueAmount;
	}

	public void setPenaltyDueAmount(double penaltyDueAmount) {
		this.penaltyDueAmount = penaltyDueAmount;
	}

	public void payPenalty() {
		if (penaltyDueAmount > 0) {
			System.out.println("You owe penalty of $" +penaltyDueAmount);
			System.out.println("Enter the amount you want to pay now:");
			Scanner in = new Scanner(System.in);
			Double payingAmount = in.nextDouble();
			penaltyDueAmount = penaltyDueAmount - payingAmount;
			
			System.out.println(">>>>>>LOG: $" + penaltyDueAmount + " has beed credited to your account");
			System.out.println(">>>>>>LOG: Your new account balance of penalty amount is: " +penaltyDueAmount);
			
		} else  {
			System.out.println(">>>>>>LOG: You do not owe any penalty at this moment.");
		}
	}
	
	public void issueBook(Book book) {
		book.setOnLoan(true);
		System.out.println(">>>>>>LOG: Book issued.");
		System.out.println("Book: " +book.getTitle() + " is issued to you.");
	}
	
	public void returnBook(Book book) {
		book.setOnLoan(false);
		System.out.println(">>>>>>LOG: Book returned.");
		System.out.println("Book: " +book.getTitle() + " is returned.");
		Date returningDate = new Date();
		System.out.println("Return date and time is: " + returningDate.toString());
	}
	
	public void searchBook(String searchKeyword) {
		
		// Gets all books name
		List <String> searchResult = new ArrayList<String>(); 
		
		ArrayList<Book> availableBooksList = booksList;
		
		for (Book book : availableBooksList) {
			String bookTitle = book.getTitle();
			if (bookTitle.toLowerCase().contains(searchKeyword.toLowerCase())) {
				searchResult.add(bookTitle);
			}
		}
		
		if (!searchResult.isEmpty()) {
			System.out.println(">>>>>>LOG: Follwoing books found based on your search keyword:");
			
			for (String bookName : searchResult) {
				System.out.println(bookName);
			}
		} else {
			System.out.println(">>>>>>LOG: No books found based on your search keyword.");
		}

	}

}
