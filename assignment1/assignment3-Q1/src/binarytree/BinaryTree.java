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

	// recursive method for mirror inverse
	private void mirrorInverse(BTNode<T> root) {
		if (root == null)
			return;

		// swap left and right
		BTNode<T> tmp = root.getLeftChild();
		root.setLeftChild(root.getRightChild());
		root.setRightChild(tmp);

		mirrorInverse(root.getLeftChild());
		mirrorInverse(root.getRightChild());
	}

	/**
	 * reverse the tree so that the result
	 * is a mirror image of the original tree
	 */
	public void mirrorInverse() {
		mirrorInverse(this.root);
	}


	private static <T> BTNode<T> createRootFromInorderPreorder(List<T> inOrder, List<T> preOrder,
			int inOrderStart, int inOrderEnd, int preOrderStart, int preOrderEnd) {

		if (inOrderEnd-inOrderStart != preOrderEnd-preOrderStart)
			throw new IllegalArgumentException("lists not equal sizes");

		if (inOrderStart > inOrderEnd)
			return null;
					
		BTNode<T> root = new BTNode<T>(preOrder.get(preOrderStart));

		// find the index of root in inOrder list
		int inOrderRoot = inOrderStart;
		while (!inOrder.get(inOrderRoot).equals(preOrder.get(preOrderStart)))
			inOrderRoot++;
		int leftSize = inOrderRoot - inOrderStart;

		// create left subtree
		BTNode<T> left =  createRootFromInorderPreorder(inOrder, preOrder,
				inOrderStart, inOrderRoot - 1,
				preOrderStart + 1, preOrderStart + leftSize);
		root.setLeftChild(left);

		// create right subtree
		BTNode<T> right =  createRootFromInorderPreorder(inOrder, preOrder,
				inOrderRoot + 1, inOrderEnd,
				preOrderStart + leftSize + 1, preOrderEnd);
		root.setRightChild(right);

		return root;
	}


	/**
	 * 
	 * gets inOrder and preOrder of a binary tree and recovers the tree
	 * @param inOrder
	 * @param preOrder
	 * @return
	 */
	public static <T> BinaryTree<T> createFromPreorderInorder(List<T> inOrder, List<T> preOrder) {
		if (inOrder.size() != preOrder.size())
			throw new IllegalArgumentException("lists not equal sizes");
		
		return new BinaryTree<T>(createRootFromInorderPreorder(inOrder, preOrder,
				0, inOrder.size()-1,
				0, preOrder.size()-1));
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
		return new InOrderIterator<T>(this);
	}


}
