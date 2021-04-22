package binarytree;

import java.util.*;

public class BinaryTree<T> {

	Vector<T> vec = new Vector<T>();
	private BTNode<T> root;
	NoSuchElementException ex = new NoSuchElementException("Root DNE");
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

	public BTNode<T> mirrorInverse(BTNode<T> input){

		if(input == null){
			return null;
		}

		BTNode left = mirrorInverse(input.getLeftChild());
		BTNode right = mirrorInverse(input.getRightChild());

		input.setRightChild(left);
		input.setLeftChild(right);

		return input;

	}


	public void mirrorInverse() {
		if(root == null){
			throw ex;
		}
		root = mirrorInverse(root);
	}

	/**
	 * 
	 * gets inOrder and preOrder of a binary tree and recovers the tree
	 * @param inOrder
	 * @param preOrder
	 * @return
	 */
	public static <T> BTNode <T> bstArray(int preorderStart, int inorderStart, int inorderEnd, List<T> preOrder, List<T> inOrder){
		if(preorderStart > preOrder.size() - 1 || inorderStart > inorderEnd){
			return null;
		}


		BTNode tempRoot = new BTNode(preOrder.get(preorderStart));
		int i = 0;
		for(int j = inorderStart; j <= inorderEnd; j++){
			if(tempRoot.getData() == inOrder.get(j)){
				i = j;
			}
		}


		tempRoot.setLeftChild(bstArray(preorderStart + 1, inorderStart, i -1, preOrder, inOrder));
		tempRoot.setRightChild(bstArray(preorderStart + i - inorderStart + 1, i + 1, inorderEnd, preOrder,  inOrder));

		return tempRoot;
	}

	public static <T> BinaryTree<T> createFromPreorderInorder(List<T> inOrder, List<T> preOrder) {
		BinaryTree<T> myTree = new BinaryTree<T>(bstArray(0,0, inOrder.size() - 1, preOrder, inOrder));
		return myTree;
	}

	/**
	 * creates an inOrder iterator for this.
	 * the iterator is dynamic in the following sense:
	 * If after the iterator is created, and the tree changes in some part
	 * that has not been processed by the iterator, then the iterator will see these changes
	 * and output the values in the updated tree 
	 * @return
	 */

	public void getInorder(BTNode<T> node)
	{
		if (node == null)
			return;

		getInorder(node.getLeftChild());
		vec.addElement(node.getData());
		getInorder(node.getRightChild());
	}

	public Iterator<T> inOrderIterator() {
		vec.clear();
		getInorder(root);
		Iterator<T> it = vec.iterator();
		return vec.iterator();
	}

}
