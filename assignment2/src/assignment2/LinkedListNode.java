package assignment2;

import java.util.*;

/**
 * Implementation of linked list
 *   
 * @author Igor
 *
 */

public class LinkedListNode<T> {

	private T data;
	private LinkedListNode<T> next;
	private boolean visited = false;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}

	public LinkedListNode(T data, LinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	public LinkedListNode<T> getNext() {
		return next;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
	
	public int countReachableNodes() {
		int ans = 1;
		LinkedListNode<T> current = this, start = this;

		while(current.next != null) {
			if(current.next.visited) {
				break;
			}
			else {
				current.visited = true;
			}
			current = current.next;
			ans++;
		}
		current = start;

		while(current.visited) {
			current.visited = false;
			current = current.next;
		}
		return ans;
	}
}