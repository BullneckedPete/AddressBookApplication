package Addressbook;

public interface Iterator {
	
	/**
	 * Indicates if the iterator has a next element.
	 * @return true, if the is a next element, false otherwise
	 */
	public boolean hasNext();
	
	/**
	 * Returns the next element.
	 * @return next element of the iteration
	 */
	public Object next();
	
}
