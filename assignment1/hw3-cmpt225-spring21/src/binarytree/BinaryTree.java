package binarytree;

import java.util.*;

public class BinaryTree<T> {

	private BTNode<T> root;

	public BinaryTree(BTNode<T> root) {
		this.root = root;
	}

	public BTNode<T> getRoot() {
		return root;
	}

	/**
	 * reverse the tree so that the result
	 * is a mirror image of the original tree
	 */
	public void mirrorInverse() {
		// TODO implement me
	}

	/**
	 * 
	 * gets inOrder and preOrder of a binary tree and recovers the tree
	 * @param inOrder
	 * @param preOrder
	 * @return
	 */
	public static <T> BinaryTree<T> createFromPreorderInorder(List<T> inOrder, List<T> preOrder) {
		// TODO implement me
		return null;
	}

	/**
	 * creates an inOrder iterator for this.
	 * the iterator is dynamic in the following sense:
	 * If after the iterator is created, and the tree changes in some part
	 * that has not been processed by the iterator, then the iterator will see these changes
	 * and output the values in the updated tree 
	 * @return
	 */
	public Iterator<T> inOrderIterator() {
		// TODO implement me
		// may use an inner class or a standalone class in a separate file
		return null;
	}


}
