package assignment2;

import java.util.*;

public class CircularLinkedList<T> {

	Vector<T> DLL = new Vector<T>();
	int size;
	int position = 0;

	NoSuchElementException ex = new NoSuchElementException("No such element");

	public CircularLinkedList() {
		size = 0;
	}

	public CircularLinkedList(int initSize, T initValue) {
		for(int i = 0; i < initSize; i++) {
			DLL.addElement(initValue);
		}
		size = initSize;
	}

	public void moveForward() {
		if(size == 0) {
			throw ex;
		}
		else if(position == size - 1) {
			position = 0;
		}
		else {
			position++;
		}
	}

	public void moveBackward() {
		if(size == 0) {
			throw ex;
		}
		else if(position == 0) {
			position = size - 1;
		}
		else {
			position--;
		}
	}

	public T getValue() {
		if(size == 0) {
			throw ex;
		}
		else {
			return DLL.get(position);
		}
	}

	/**
	 * @return the previous value of the updated node
	 */
	public T setValue(T value) {
		if(size == 0) {
			throw ex;
		}
		else {
			T old = DLL.get(position);
			DLL.set(position, value);
			return old;
		}
	}

	public void addBefore(T value) {
		Vector<T> copy = new Vector<T>();
		if(size == 0) {
			DLL.addElement(value);
		}
		else {
			for(int i = 0; i < size; i++) {
				if(i == position) {
					copy.addElement(value);
					copy.addElement(DLL.get(i));
					continue;
				}
				copy.addElement(DLL.get(i));
			}
			DLL = copy;
		}
		size++;
	}

	public void addAfter(T value) {
		Vector<T> copy = new Vector<T>();
		if(size == 0) {
			DLL.addElement(value);
		}
		else {
			for(int i = 0; i < size; i++) {
				if(i == position) {
					copy.addElement(DLL.get(i));
					copy.addElement(value);
					continue;
				}
				copy.addElement(DLL.get(i));
			}
			DLL = copy;
		}
		size++;
	}

	/**
	 * @return the previous value of the removed node
	 */
	public T removeBefore() {
		if(size == 0) {
			throw ex;
		}
		else {
			T removed;
			if(position == 0) {
				removed = DLL.remove(size - 1);
			}
			else {
				removed = DLL.remove(position - 1);
			}
			position--;
			size--;
			return removed;
		}
	}

	/**
	 * @return the previous value of the removed node
	 */
	public T removeAfter() {
		if(size == 0) {
			throw ex;
		}
		else {
			T removed;
			if(position == size - 1) {
				removed = DLL.remove(0);
			}
			else {
				removed = DLL.remove(position + 1);
			}
			position--;
			size--;
			return removed;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
