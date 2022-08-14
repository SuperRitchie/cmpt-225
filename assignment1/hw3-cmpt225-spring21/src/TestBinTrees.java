import java.util.*;


import binarytree.*;

public class TestBinTrees {

	private static BinaryTree<Integer> createTree() {
		// creating the tree
		//       5
		//      / \
		//     2   6
		//    / \   \
		//   1   4   8
		BTNode<Integer> node8 = new BTNode<Integer>(8);
		BTNode<Integer> node6 = new BTNode<Integer>(6, null, node8, null);

		BTNode<Integer> node1 = new BTNode<Integer>(1);
		BTNode<Integer> node4 = new BTNode<Integer>(4);
		BTNode<Integer> node2 = new BTNode<Integer>(2, node1, node4, null);

		BTNode<Integer> node5 = new BTNode<Integer>(5, node2, node6, null);


		return new BinaryTree<Integer>(node5);
	}


	public static void testMirrorInverse() {
		BinaryTree<Integer> tree = createTree();
		tree.mirrorInverse();
		if (tree != null && tree.getRoot().getData() == 5)
			System.out.println("testMirrorInverse1 ok");
		else
			System.out.println("testMirrorInverse1 fail");

		BTNode<Integer> root = tree.getRoot();
		if (root.getLeftChild() != null && root.getLeftChild().getData() == 6)
			System.out.println("testMirrorInverse2 ok");
		else
			System.out.println("testMirrorInverse2 fail");


		BTNode<Integer> six = root.getLeftChild();
		if (six.getLeftChild() != null && six.getLeftChild().getData() == 8)
			System.out.println("testMirrorInverse3 ok");
		else
			System.out.println("testMirrorInverse3 fail");


	}


	public static void testTreeFromTraversals() {
		// creating the tree
		//       3
		//      / \
		//     2   5
		//    /   / \
		//   1   4   6

		List<Integer> inorder = Arrays.asList(1,2,3,4,5,6);
		List<Integer> preorder = Arrays.asList(3,2,1,5,4,6);
		
		BinaryTree<Integer> tree =
				(BinaryTree<Integer>) BinaryTree.createFromPreorderInorder(inorder, preorder);
		
		if (tree == null)
			System.out.println("testCreatingTree fail root == null");
		BTNode<Integer> root = tree.getRoot();
		if (root != null && root.getData() == 3)
			System.out.println("testCreatingTree root ok");
		else
			System.out.println("testCreatingTree root fail");

		BTNode<Integer> two = root.getLeftChild();
		if (two != null && two.getData() == 2)
			System.out.println("testCreatingTree 2 ok");
		else
			System.out.println("testCreatingTree 2 fail");
		
		if (two.getRightChild() == null)
			System.out.println("testCreatingTree 2.right()==null ok");
		else
			System.out.println("testCreatingTree 2.right()==null fail");
	}

	public static void testInOrderIterator1() {
		BinaryTree<Integer> tree = createTree();
		Iterator<Integer> inOrderIt = tree.inOrderIterator();

		List<Integer> vals = Arrays.asList(new Integer[] {1,2,4,5,6,8});

		for (Iterator<Integer> it = vals.iterator();it.hasNext();) {
			int expected = (int) it.next();
			if (inOrderIt.hasNext() && inOrderIt.next() == expected)
				System.out.println("testInOrderIterator " + expected + " : ok");
			else
				System.out.println("testInOrderIterator " + expected + " : fail");
		}

		if (inOrderIt.hasNext())
			System.out.println("testInOrderIterator hasNext(): fail");
		else
			System.out.println("testInOrderIterator hasNext(): ok");
	}


	public static void testInOrderIterator2() {
		BinaryTree<Integer> tree = createTree();
		Iterator<Integer> inOrderIt = tree.inOrderIterator();

		List<Integer> vals = Arrays.asList(new Integer[] {1,2});

		for (Iterator<Integer> it = vals.iterator();it.hasNext();) {
			int expected = (int) it.next();
			if (inOrderIt.hasNext() && inOrderIt.next() == expected)
				System.out.println("testInOrderIterator " + expected + " : ok");
			else
				System.out.println("testInOrderIterator " + expected + " : fail");
		}

		// changing the value 8 to 9, and expecting the iterator to catch this 
		tree.getRoot().getRightChild().getRightChild().setData(9);

		vals = Arrays.asList(new Integer[] {4,5,6,9});
		for (Iterator<Integer> it = vals.iterator();it.hasNext();) {
			int expected = (int) it.next();
			if (inOrderIt.hasNext() && inOrderIt.next() == expected)
				System.out.println("testInOrderIterator " + expected + " : ok");
			else
				System.out.println("testInOrderIterator " + expected + " : fail");
		}


		if (inOrderIt.hasNext())
			System.out.println("testInOrderIterator hasNext(): fail");
		else
			System.out.println("testInOrderIterator hasNext(): ok");
	}

	public static void main(String[] args) {

		testMirrorInverse();
		testTreeFromTraversals();
		testInOrderIterator1();
		testInOrderIterator2();

	}

}
