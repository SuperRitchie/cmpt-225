import java.util.*;


import binarytree.*;

public class TestBinTrees {

	private static boolean compareBinaryTree(BTNode<Integer> root1, BTNode<Integer> root2){
		if ((root1 == null && root2 !=null) || (root1 != null && root2 == null))
			// one of them is null and the other is not!
			return false;

		if (root1 == null && root2 == null)
			// both are null
			return true;

		if(!root1.getData().equals(root2.getData()))
			// root1 and root2 have different data
			return false;

		boolean leftSubTree = compareBinaryTree(root1.getLeftChild(), root2.getLeftChild());
		boolean rightSubTree = compareBinaryTree(root1.getRightChild(), root2.getRightChild());
		return (leftSubTree & rightSubTree);
	}

	private static BinaryTree<Integer> createTree1() {
		// creating the tree
		//       5
		//      / \
		//     2   6
		//    / \   \
		//   1   4   8
		// in order:  1, 2, 4, 5, 6, 8
		// pre order: 5, 2, 1, 4, 6, 8
		BTNode<Integer> node8 = new BTNode<Integer>(8);
		BTNode<Integer> node6 = new BTNode<Integer>(6, null, node8, null);

		BTNode<Integer> node1 = new BTNode<Integer>(1);
		BTNode<Integer> node4 = new BTNode<Integer>(4);
		BTNode<Integer> node2 = new BTNode<Integer>(2, node1, node4, null);

		BTNode<Integer> node5 = new BTNode<Integer>(5, node2, node6, null);


		return new BinaryTree<Integer>(node5);
	}

	private static BinaryTree<Integer> createTree1Inverse() {
		// creating the tree
		//       5
		//      / \
		//     2   6
		//    / \   \
		//   1   4   8
		BTNode<Integer> node8 = new BTNode<Integer>(8);
		BTNode<Integer> node6 = new BTNode<Integer>(6, node8, null, null);

		BTNode<Integer> node1 = new BTNode<Integer>(1);
		BTNode<Integer> node4 = new BTNode<Integer>(4);
		BTNode<Integer> node2 = new BTNode<Integer>(2, node4, node1, null);

		BTNode<Integer> node5 = new BTNode<Integer>(5, node6, node2, null);


		return new BinaryTree<Integer>(node5);
	}



	private static BinaryTree<Integer> createTree2() {
		// creating the tree
		//       1
		//      /
		//     2
		//    /
		//   3
		//    \
		//      4
		//       \
		//        5
		// in order: 3, 4, 5, 2, 1
		// pre order: 1, 2, 3, 4, 5
		BTNode<Integer> node5 = new BTNode<Integer>(5);
		BTNode<Integer> node4 = new BTNode<Integer>(4, null, node5, null);

		BTNode<Integer> node3 = new BTNode<Integer>(3, null, node4, null);
		BTNode<Integer> node2 = new BTNode<Integer>(2, node3, null, null);
		BTNode<Integer> node1 = new BTNode<Integer>(1, node2, null, null);

		return new BinaryTree<Integer>(node1);
	}

	private static BinaryTree<Integer> createTree2Inverse() {
		// creating the tree
		//       1
		//        \
		//         2
		//          \
		//           3
		//          /
		//         4
		//        /
		//       5
		//
		// in order: 1, 2, 5, 4, 3
		// pre order: 1, 2, 3, 4, 5
		BTNode<Integer> node5 = new BTNode<Integer>(5);
		BTNode<Integer> node4 = new BTNode<Integer>(4, node5, null, null);

		BTNode<Integer> node3 = new BTNode<Integer>(3, node4, null, null);
		BTNode<Integer> node2 = new BTNode<Integer>(2, null, node3, null);
		BTNode<Integer> node1 = new BTNode<Integer>(1, null, node2, null);

		return new BinaryTree<Integer>(node1);
	}

	// --- Question A part 1
	public static void testMirrorInverse1() {
		BinaryTree<Integer> tree = createTree1();
		BinaryTree<Integer> treeInverse = createTree1Inverse();

		tree.mirrorInverse();
		if(compareBinaryTree(tree.getRoot(), treeInverse.getRoot()))
			System.out.println("AC");
		else
			System.out.println("WA");
	}

	public static void testMirrorInverse2() {
		BinaryTree<Integer> tree = createTree2();
		BinaryTree<Integer> treeInverse = createTree2Inverse();

		tree.mirrorInverse();
		if(compareBinaryTree(tree.getRoot(), treeInverse.getRoot()))
			System.out.println("AC");
		else
			System.out.println("WA");
	}


	// --- Question A part 2
	public static void testTreeFromTraversals1() {
		//using createTree1
		BinaryTree<Integer> correctTree = createTree1();

		List<Integer> inorder = Arrays.asList(1, 2, 4, 5, 6, 8);
		List<Integer> preorder = Arrays.asList(5, 2, 1, 4, 6, 8);

		BinaryTree<Integer> tree =
				(BinaryTree<Integer>) BinaryTree.createFromPreorderInorder(inorder, preorder);
		
		if (compareBinaryTree(correctTree.getRoot(), tree.getRoot()))
			System.out.println("AC");
		else
			System.out.println("WA");
	}

	public static void testTreeFromTraversals2() {
		//using createTree2
		BinaryTree<Integer> correctTree = createTree2();

		List<Integer> inorder = Arrays.asList(3, 4, 5, 2, 1);
		List<Integer> preorder = Arrays.asList(1, 2, 3, 4, 5);

		BinaryTree<Integer> tree =
				(BinaryTree<Integer>) BinaryTree.createFromPreorderInorder(inorder, preorder);

		if (compareBinaryTree(correctTree.getRoot(), tree.getRoot()))
			System.out.println("AC");
		else
			System.out.println("WA");
	}



	// --- Question A part 3
	public static void testInOrderIterator1() {
		BinaryTree<Integer> tree = createTree1();
		Iterator<Integer> inOrderIt = tree.inOrderIterator();

		List<Integer> vals = Arrays.asList(new Integer[] {1, 2, 4, 5, 6, 8});

		for (Iterator<Integer> it = vals.iterator();it.hasNext();) {
			int expected = (int) it.next();
			if (inOrderIt.hasNext() && inOrderIt.next() != expected) {
				System.out.println("WA");
				return;
			}
		}

		if (inOrderIt.hasNext())
			System.out.println("WA");
		else
			System.out.println("AC");
	}


	public static void testInOrderIterator2() {
		BinaryTree<Integer> tree = createTree2();
		Iterator<Integer> inOrderIt = tree.inOrderIterator();

		List<Integer> vals = Arrays.asList(new Integer[] { 3, 4, 5, 2, 1});

		for (Iterator<Integer> it = vals.iterator();it.hasNext();) {
			int expected = (int) it.next();
			if (inOrderIt.hasNext() && inOrderIt.next() != expected) {
				System.out.println("WA");
				return;
			}
		}

		if (inOrderIt.hasNext())
			System.out.println("WA");
		else
			System.out.println("AC");
	}


	public static void testInOrderIterator3() {
		BinaryTree<Integer> tree = createTree1();
		Iterator<Integer> inOrderIt = tree.inOrderIterator();

		List<Integer> vals = Arrays.asList(new Integer[] {1,2});

		for (Iterator<Integer> it = vals.iterator();it.hasNext();) {
			int expected = (int) it.next();
			if (inOrderIt.hasNext() && inOrderIt.next() != expected){
				System.out.println("WA");
				return;
			}
		}

		// changing the value 8 to 9, and expecting the iterator to catch this 
		tree.getRoot().getRightChild().getRightChild().setData(9);

		vals = Arrays.asList(new Integer[] {4,5,6,9});
		for (Iterator<Integer> it = vals.iterator();it.hasNext();) {
			int expected = (int) it.next();
			if (inOrderIt.hasNext() && inOrderIt.next() != expected) {
				System.out.println("WA");
				return;
			}
		}

		if (inOrderIt.hasNext())
			System.out.println("WA");
		else
			System.out.println("AC");
	}


	public static void testInOrderIterator4() {
		BinaryTree<Integer> tree = createTree1();
		Iterator<Integer> inOrderIt = tree.inOrderIterator();

		List<Integer> vals = Arrays.asList(new Integer[] {1,2});

		for (Iterator<Integer> it = vals.iterator();it.hasNext();) {
			int expected = (int) it.next();
			if (inOrderIt.hasNext() && inOrderIt.next() != expected){
				System.out.println("WA");
				return;
			}
		}

		// adding 3 as the left child of node 4
		BTNode<Integer> node4 = tree.getRoot().getLeftChild().getRightChild();
		BTNode<Integer> node3 = new BTNode<Integer>(3, null, null, node4);
		node4.setLeftChild(node3);

		vals = Arrays.asList(new Integer[] {3,4,5,6,8});
		for (Iterator<Integer> it = vals.iterator();it.hasNext();) {
			int expected = (int) it.next();
			if (inOrderIt.hasNext() && inOrderIt.next() != expected) {
				System.out.println("WA");
				return;
			}
		}

		if (inOrderIt.hasNext())
			System.out.println("WA");
		else
			System.out.println("AC");
	}

	public static void main(String[] args) {
		String testID = args[0];
		switch (testID) {
			case "testMirrorInverse1":
				testMirrorInverse1();
				break;
			case "testMirrorInverse2":
				testMirrorInverse2();
				break;
			case "testTreeFromTraversals1":
				testTreeFromTraversals1();
				break;
			case "testTreeFromTraversals2":
				testTreeFromTraversals2();
				break;
			case "testInOrderIterator1":
				testInOrderIterator1();
				break;
			case "testInOrderIterator2":
				testInOrderIterator2();
				break;
			case "testInOrderIterator3":
				testInOrderIterator3();
				break;
			case "testInOrderIterator4":
				testInOrderIterator4();
				break;
		}
	}

}


// creating the tree
//       3
//      / \
//     2   5
//    /   / \
//   1   4   6
