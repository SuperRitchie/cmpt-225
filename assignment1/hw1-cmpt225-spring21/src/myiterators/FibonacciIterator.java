package myiterators;

import javax.sound.midi.ControllerEventListener;

public class FibonacciIterator implements IntegerIterator
{
	int[] a;
	int c = 0;
	boolean flag = true;

	int n_1, n_2;
	int one, two;

	/**
	 * Creates a default Fibonacci Iterator with a0=0 and a1=1 
	 */
	public FibonacciIterator() {
		n_1 = 1;
		n_2 = 0;

		one = 1;
		two = 0;
	}
	
	/**
	 * @param a0 the zero element of the sequence 
	 * @param a1 the n_1 element of the sequence
	 */
	public FibonacciIterator(int a0, int a1) {
		n_1 = a1;
		n_2 = a0;

		one = a1;
		two = a0;

	}

	public boolean hasNext() {
		return true;
	}
	
	public int getNext() {
		if(c == 0) {
			c = 1;
			return n_2;
		}
		else if(c == 1) {
			c = -1;
			return n_1;
		}
		else {
			if(flag) {
				flag = false;
				return n_1 + n_2;
			}
			int copy = n_2;
			n_2 = n_1;
			n_1 = n_1 + copy;
			return n_1 + n_2;
		}

	}
	
	public void reset() {
		c = 0;
		flag = true;

		n_1 = one;
		n_2 = two;
	}
	
}
