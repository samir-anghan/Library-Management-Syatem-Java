/**
 * 
 */
package lms.books;

/**
 * @author Samir
 *
 */
public class BookFactory {
	
	public Book retrieveBook(String bookType) {
		
		if (bookType.equalsIgnoreCase("textbook")) {
			return new TextBook();
		} else if (bookType.equalsIgnoreCase("journal")) {
			return new Journal();
		} else if (bookType.equalsIgnoreCase("Novels")) {
			return new Novels();
		}
		
		return null;
	}

}
