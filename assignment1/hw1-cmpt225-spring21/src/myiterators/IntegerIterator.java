package myiterators;

public interface IntegerIterator
{
	/**
	 * @return true if the iterator has more elements
	 * and returns false otherwise
	 */
	public boolean hasNext();
	
	/**
	 * @return true the next element
	 */
	public int getNext();
	
	/**
	 * resets the iterator to the beginning of the sequence
	 */
	public void reset();
}
