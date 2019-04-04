/**
 * 
 */
package lms.users;

/**
 * @author Samir
 *
 */
public class GuestUser {

	private static GuestUser TheUniqueGuestUser;

	public static GuestUser getInstance() {
		if (GuestUser.TheUniqueGuestUser == null) {
			GuestUser.TheUniqueGuestUser = new GuestUser();
		}
		return GuestUser.TheUniqueGuestUser;
	}
	
	// To prevent creating instance
	private GuestUser() {
		
	}

	public void signUp() {
		System.out.println("\nSigning up.....");
	}

	public void searchBook() {
		System.out.println("\nSearching book.....");
	}

}
