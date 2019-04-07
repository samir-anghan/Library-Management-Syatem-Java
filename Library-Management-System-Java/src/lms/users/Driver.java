/**
 * 
 */
package lms.users;

import java.util.Scanner;

/**
 * @author Samir
 *
 */
public class Driver {

	public static void main(String[] args) {

		HelperDriver helperDriver = new HelperDriver();
		
		helperDriver.initialSetup();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("=============== :: LIBRARY MANAGEMENT SYSTEM :: ===============");
		System.out.println("                           GROUP: H");
		System.out.println("===============================================================");
		
		System.out.println("\nSelect user type:\n");
		System.out.println("Press 1 for Guest user,");
		System.out.println("Press 2 for User,");
		System.out.println("Press 3 for Admin:");
		
		int userChoice = in.nextInt();
		
		switch (userChoice) {
		case 1:
			System.out.println(">>>>>>LOG: You have selected Guest user.");
			helperDriver.processGuestUser();
			break;
			
		case 2:
			System.out.println(">>>>>>LOG: You have selected User.");
			helperDriver.processUser();
			break;
		
		case 3:
			System.out.println(">>>>>>LOG: You have selected Admin.");
			helperDriver.processAdmin();
			break;
			
		default:
			System.out.println("\nINVALID CHOICE !!! \nRun again to use the library management system.");
			break;
		}
	}
	
}
