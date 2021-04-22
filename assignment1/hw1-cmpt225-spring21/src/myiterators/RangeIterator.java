package myiterators;

public class RangeIterator implements IntegerIterator
{
	int[] construct;
	int c = 0;
	/**
	 * @param n
	 * Creates an iterator with range 0,1, ..., n-1
	 */
	public RangeIterator(int n) {
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = i;
		}
		construct = a;
	}
	
	/**
	 * @param n
	 * Creates an iterator with range a0, a0+1, ..., n-1
	 */
	public RangeIterator(int a0, int n) {
		int[] a = new int[n];
		int counter = 1;
		a[0] = a0;
		for(int i = a0; i < n; i++) {
			if(a0 + counter > n - 1) {
				break;
			}
			a[i] = a0 + counter;
			counter++;
		}
		construct = a;
	}
	
	/**
	 * @param n
	 * Creates an iterator with range a0, a0+diff, , a0+2*diff, ..., a0+k*diff
	 * for the maximal k such that a0+k*diff<n
	 */
	public RangeIterator(int a0, int n, int diff) {
		int counter = 0;
		for(int i = 1; i < n; i++) {
			if(a0 + i*diff >= n) {
				break;
			}
			counter++;
		}
		int[] a = new int[++counter];
		a[0] = a0;
		for(int i = 1; i < n; i++) {
			if(a0 + i*diff >= n) {
				break;
			}
			a[i] = a0 + i*diff;
		}
		construct = a;
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
