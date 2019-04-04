/**
 * 
 */
package lms.users;

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
	
	public double getPenaltyDueAmount() {
		return penaltyDueAmount;
	}

	public void setPenaltyDueAmount(double penaltyDueAmount) {
		this.penaltyDueAmount = penaltyDueAmount;
	}

	public void payPenalty() {
		
	}
	
	public void issueBook() {
		
	}
	
	public void returnBook() {
		
	}
	
	public void searchBook(String bookName) {
		
	}

}
