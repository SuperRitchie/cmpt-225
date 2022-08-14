import arithmetic.ArithmeticExpressions;
import binarytree.*;

public class TestArithmeticExpressions {

	static void i2pTest(String infix, String prefix, int i) {
		String res = ArithmeticExpressions.infix2Prefix(infix);
		if (prefix.equals(res))
			System.out.println("AC");
		else
			System.out.println("WA" );

	}


	static void testInfix2Prefix() {
		i2pTest("( 1 + 6 )",
				"+ 1 6",
				1);

		i2pTest("( 10.5 * ( ( 8.6 + 2.4 ) / 5.5 ) )",
				"* 10.5 / + 8.6 2.4 5.5",
				2);

		i2pTest("( ( 6 + 3 ) / ( 6 - ( 9 / 3 ) ) ) ",
				"/ + 6 3 - 6 / 9 3",
				3);


		i2pTest("( ( 1.1 + 0.4 ) / ( ( 7.9 + 0 ) - ( 13.25 + 18.04 ) ) ) ",
				"/ + 1.1 0.4 - + 7.9 0 + 13.25 18.04",
				4);
	}

	static void testPostfix2BinaryTree1() {
		String postFix1 = "1 6 +";
		BTNode<Double> root1 = ArithmeticExpressions.postfix2BinaryTree(postFix1);
		// expected solution:
		//		    PLUS
		//         /    \
		//       1.0     6.0   
		if (!(root1 != null
				&& root1.getData() == ArithmeticExpressions.PLUS
				&& root1.getLeftChild() != null && root1.getLeftChild().getData() == 1
				&& root1.getRightChild() != null && root1.getRightChild().getData() == 6)) {
			System.out.println("WA");
			return;
		}


		String postFix2 = "4.5 0.2 * 6.0 /"; 
		BTNode<Double> root2 = ArithmeticExpressions.postfix2BinaryTree(postFix2);
		// expected solution:
		//			 DIV
		//         /    \
		//       MULT    6   
		//     /     \
		//   4.5     0.2
		if (!(root2 != null
				&& root2.getData() == ArithmeticExpressions.DIV
				&& root2.getRightChild() != null && root2.getRightChild().getData() == 6
				&& root2.getLeftChild() != null && root2.getLeftChild().getData() == ArithmeticExpressions.MULT
				&& root2.getLeftChild().getLeftChild() != null && root2.getLeftChild().getLeftChild().getData() == 4.5
				&& root2.getLeftChild().getRightChild() != null && root2.getLeftChild().getRightChild().getData() == 0.2)) {
			System.out.println("WA");
			return;
		}

		System.out.println("AC");

	}






	private static boolean compareBinaryTree(BTNode<Double> root1, BTNode<Double> root2){
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

	private static BinaryTree<Double> createTree1() {
		// creating the tree
		//         -(A)
		//      /    \
		//     +(B)   *(C)
		//    / \    /    \
		//   1   4   +(D)  8.3
		//          / \
		//         2   3.1
		// postFix1 = "1 4 + 2 3.1 + 8.3 * -";

		BTNode<Double> node1 = new BTNode<Double>(1.0);
		BTNode<Double> node4 = new BTNode<Double>(4.0);
		BTNode<Double> B = new BTNode<Double>(1.0*ArithmeticExpressions.PLUS,
				node1, node4, null);

		BTNode<Double> node2 = new BTNode<Double>(2.0);
		BTNode<Double> node3point1 = new BTNode<Double>(3.1);
		BTNode<Double> D = new BTNode<Double>(1.0*ArithmeticExpressions.PLUS,
				node2, node3point1, null);

		BTNode<Double> node8point3 = new BTNode<Double>(8.3);
		BTNode<Double> C = new BTNode<Double>(1.0*ArithmeticExpressions.MULT,
				D, node8point3, null);

		BTNode<Double> A = new BTNode<Double>(1.0*ArithmeticExpressions.MINUS,
				B, C, null);

		return new BinaryTree<Double>(A);
	}


	private static void testPostfix2BinaryTree2(){
		String postFix1 = "1 4 + 2 3.1 + 8.3 * -";
		BTNode<Double> root1 = ArithmeticExpressions.postfix2BinaryTree(postFix1);
		BinaryTree<Double> correctTree = createTree1();
		if (compareBinaryTree(root1, correctTree.getRoot()))
			System.out.println("AC");
		else
			System.out.println("WA");
	}


	public static void main(String[] args) {
//		testInfix2Prefix();
//		testPostfix2BinaryTree();
		String testID = args[0];
		switch (testID) {
			case "testInfix2Prefix1":
				i2pTest("( 1 + 6 )",
						"+ 1 6",
						1);
				break;
			case "testInfix2Prefix2":
				i2pTest("( 10.5 * ( ( 8.6 + 2.4 ) / 5.5 ) )",
						"* 10.5 / + 8.6 2.4 5.5",
						2);
				break;
			case "testInfix2Prefix3":
				i2pTest("( ( 6 + 3 ) / ( 6 - ( 9 / 3 ) ) ) ",
						"/ + 6 3 - 6 / 9 3",
						3);
				break;
			case "testInfix2Prefix4":
				i2pTest("( ( 1.1 + 0.4 ) / ( ( 7.9 + 0 ) - ( 13.25 + 18.04 ) ) ) ",
						"/ + 1.1 0.4 - + 7.9 0 + 13.25 18.04",
						4);
				break;
			case "testPostfix2BinaryTree1":
				testPostfix2BinaryTree1();
				break;
			case "testPostfix2BinaryTree2":
				testPostfix2BinaryTree2();
				break;
		}
	}

}
