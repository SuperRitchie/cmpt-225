package assignment2;

import java.util.ArrayList;
import mystack.MyStack;

/**
 * Additional operations on MyStack
 *
 * @author Igor
 *
 */

public class MyStackOperations<T>{

	public static <T> int size(MyStack<T> s) {
		int size = 0;
		MyStack<T> copy = new MyStack<T>();

		while (!s.isEmpty()) {
			copy.push(s.pop());
			size++;
		}

		while (!copy.isEmpty()) {
			s.push(copy.pop());
		}
		return size;
	}

	public static <T> MyStack<T> cloneStack(MyStack<T> s) {
		MyStack<T> copy = new MyStack<T>(), copy1 = new MyStack<T>(), copy2 = new MyStack<T>();
		T data;

		while (!s.isEmpty()) {
			data = s.pop();
			copy1.push(data);
			copy2.push(data);
		}

		while (!copy1.isEmpty()) {
			s.push(copy1.pop());
		}

		while (!copy2.isEmpty()) {
			copy.push(copy2.pop());
		}
		return copy;
	}

	public static <T> void reverse(MyStack<T> s) {
		MyStack<T> copy1 = new MyStack<T>(), copy2 = new MyStack<T>();

		while (!s.isEmpty()) {
			copy1.push(s.pop());
		}

		while (!copy1.isEmpty()) {
			copy2.push(copy1.pop());
		}

		while (!copy2.isEmpty()) {
			s.push(copy2.pop());
		}
	}
}