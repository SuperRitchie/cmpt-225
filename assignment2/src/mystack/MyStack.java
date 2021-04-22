package mystack;
/**
 * Implementing a stack using ArrayList
 * It's basically an adapter from LinkedList to Stack
 *
 * @author Igor
 *
 */

import java.util.LinkedList;
import java.util.Iterator;

public class MyStack<T> {
	private LinkedList<T> list;

	public MyStack()
	{
		list = new LinkedList<T>();
	}

	// sometimes inefficient
	public void push(T item) {
		list.addFirst(item);
	}

	public T pop() {
		return list.removeFirst();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

}
