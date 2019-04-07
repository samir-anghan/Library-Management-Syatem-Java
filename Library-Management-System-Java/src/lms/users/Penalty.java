/**
 * 
 */
package lms.users;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import lms.books.Book;
import lms.books.LoanedBook;

/**
 * @author Samir
 *
 */
public class Penalty {
	
	private int receipt_no;
	private Date date;
	
	User borrower = User.getInstance();
	LoanedBook book = new LoanedBook();
	
	public int getReceipt_no() {
		return receipt_no;
	}

	public void setReceipt_no(int receipt_no) {
		this.receipt_no = receipt_no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void calculatePenalty() {
		 int daysOverdue;
         double overdueFine;
         Date today = new Date();
         Date bookReturnDate = book.getReturnDate();
         // Calculates days between today and the book return date
         //Today is the date when borrower is actually returning the book
         //Return date is the date when borrower supposed to return a book
         long diff = today.getTime() - bookReturnDate.getTime();
         daysOverdue = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
         
         // Checks if there are any actual days overdue, and apply fine accordingly
         if (daysOverdue > 0) {
             	overdueFine = daysOverdue * 5;
             	borrower.setPenaltyDueAmount(borrower.getPenaltyDueAmount() + overdueFine);
         }

	}

	public void addPenalty(double penalty) {
		borrower.setPenaltyDueAmount(borrower.getPenaltyDueAmount() + penalty);
	}
}
