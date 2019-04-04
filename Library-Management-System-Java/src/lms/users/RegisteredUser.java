/**
 * 
 */
package lms.users;

/**
 * @author Samir
 *
 */
public class RegisteredUser {

	protected String username;
	protected int Id;
	protected String firstName;
	protected String lastName;
	protected String password;
	protected String securityQuestion;
	protected String answer;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public RegisteredUser() {
		super();
	}

	public boolean login(String userName, String passWord, String userType) {

		String typeOfUser = userType.toLowerCase();

		switch (typeOfUser) {
		case "user":
			if (userName.equalsIgnoreCase("user123") && passWord.equalsIgnoreCase("user123")) {
				System.out.println("LOG: You are now logged in as User.");
				return true;
			} else {
				System.out.println("\nInvalid username or password, try again!");
				return false;
			}

		case "admin":
			if (userName.equalsIgnoreCase("admin123") && passWord.equalsIgnoreCase("admin123")) {
				System.out.println("LOG: You are logged in as Admin.");
				return true;
			} else {
				System.out.println("\nInvalid username or password, try again!");
				return false;
			}

		default:
			return false;
		}
	}

	public void logout() {

	}

	public void forgot() {

	}

}
