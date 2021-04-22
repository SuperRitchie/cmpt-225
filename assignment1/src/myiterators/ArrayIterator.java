package myiterators;

public class ArrayIterator implements IntegerIterator
{
	int[] construct;
	int c = 0;
	/**
	 * @param ar
	 * Creates an iterator for the array 
	 */


	public ArrayIterator(int[] ar) {
		construct = ar;
	}
	
	public boolean hasNext() {
		if(c != construct.length) {
			return true;
		}
		return false;
	}
	
	public int getNext() {
		if(hasNext()) {
			return construct[c++];
		}
		return 0;
	}
	
	public void reset() {
		c = 0;
	}
}
