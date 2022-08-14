package binarytree;

import java.util.*;

public class InOrderIterator<T> implements Iterator<T>{
	
	private static class Operation<T> {
		int op; // EXPLORE or RETURN
		BTNode<T> node;
		
		Operation(int op, BTNode<T> node) {
			this.op = op;
			this.node = node;
		}
	}
	
	
	// tells the stack if the node should be explored or just returned in next()
	private static int EXPLORE = 0;
	private static int RETURN = 1;

	// an wrapper for pushing a new operation to the stack
	private void pushToStack(int op, BTNode<T> node) {
		if (node!=null)
			stack.push(new Operation<T>(op, node));
	}
	
	private Stack<Operation<T>> stack;

	/**
	 * constructor gets the tree
	 * @param tree
	 */
	public InOrderIterator(BinaryTree<T> tree) {
		stack = new Stack<Operation<T>>();
		pushToStack(EXPLORE, tree.getRoot());
	}
	
	@Override
	public boolean hasNext() {
		return (!stack.isEmpty());
	}

	@Override
	public T next() {
		Operation<T> nextOp =  stack.pop();
		if (nextOp.op == RETURN) {
			// just return the node from the top of the stack
			return nextOp.node.getData();
		}
		else { // nextOp.op == EXPLORE
			// push in reverse order
			pushToStack(EXPLORE, nextOp.node.getRightChild());
			pushToStack(RETURN, nextOp.node);
			pushToStack(EXPLORE, nextOp.node.getLeftChild());
			return next();
		}
	}


}
