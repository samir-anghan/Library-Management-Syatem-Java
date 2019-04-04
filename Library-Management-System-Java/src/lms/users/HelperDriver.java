/**
 * 
 */
package lms.users;

import java.util.Scanner;

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
		
		System.out.println("Enter user name:");
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

		switch (userChoice) {
		case 1:
			System.out.println("Searching a book.....");
			break;

		case 2:
			System.out.println("Issueing a book.....");
			break;

		case 3:
			System.out.println("Returning a book.....");
			break;

		case 4:
			System.out.println("Paying penalty.....");
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
