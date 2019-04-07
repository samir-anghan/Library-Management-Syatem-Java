/**
 * 
 */
package lms.books;

/**
 * @author Samir
 *
 */
public class Book {
	
	protected String title;
	protected String type;
	protected String author;
	protected int nop;
	protected int Id;
	protected boolean onLoan;
	
	public Book(String title, String type, String author, int nop, int id, boolean onLoan) {
		super();
		this.title = title;
		this.type = type;
		this.author = author;
		this.nop = nop;
		Id = id;
		this.onLoan = onLoan;
	}
	
	public Book() {
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNop() {
		return nop;
	}

	public void setNop(int nop) {
		this.nop = nop;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public boolean isOnLoan() {
		return onLoan;
	}

	public void setOnLoan(boolean onLoan) {
		this.onLoan = onLoan;
	}

	public void displayDetails() {
		
	}

}
