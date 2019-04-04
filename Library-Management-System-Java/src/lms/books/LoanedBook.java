/**
 * 
 */
package lms.books;

import java.util.Date;

/**
 * @author Samir
 *
 */
public class LoanedBook {
	
	private Date issueDate;
	private Date returnDate;
	private String alertMessage;
	
	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

	public int calculateDurationDays() {
		return 0;
	}
	
	public void alert() {
		
	}

}
