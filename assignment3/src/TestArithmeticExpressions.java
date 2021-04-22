import arithmetic.ArithmeticExpressions;
import binarytree.*;

public class TestArithmeticExpressions {

	static void i2pTest(String infix, String prefix, int i) {
		String res = ArithmeticExpressions.infix2Prefix(infix);
		if (prefix.equals(res))
			System.out.println("testInfix2Prefix " + i + " ok" );
		else
			System.out.println("testInfix2Prefix " + i + " fail" );

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

	static void testPostfix2BinaryTree() {
		String postFix1 = "1 6 +";
		BTNode<Double> root1 = ArithmeticExpressions.postfix2BinaryTree(postFix1);
		// expected solution:
		//		    PLUS
		//         /    \
		//       1.0     6.0   
		if (root1 != null
				&& root1.getData() == ArithmeticExpressions.PLUS
				&& root1.getLeftChild() != null && root1.getLeftChild().getData() == 1
				&& root1.getRightChild() != null && root1.getRightChild().getData() == 6)
			System.out.println("testPostfix2BinaryTree 1 ok" );
		else
			System.out.println("testPostfix2BinaryTree 1 fail" );


		String postFix2 = "4.5 0.2 * 6.0 /"; 
		BTNode<Double> root2 = ArithmeticExpressions.postfix2BinaryTree(postFix2);
		// expected solution:
		//			 DIV
		//         /    \
		//       MULT    6   
		//     /     \
		//   4.5     0.2
		if (root2 != null
				&& root2.getData() == ArithmeticExpressions.DIV
				&& root2.getRightChild() != null && root2.getRightChild().getData() == 6
				&& root2.getLeftChild() != null && root2.getLeftChild().getData() == ArithmeticExpressions.MULT
				&& root2.getLeftChild().getLeftChild() != null && root2.getLeftChild().getLeftChild().getData() == 4.5
				&& root2.getLeftChild().getRightChild() != null && root2.getLeftChild().getRightChild().getData() == 0.2
				)
			System.out.println("testPostfix2BinaryTree 2 ok" );
		else
			System.out.println("testPostfix2BinaryTree 2 fail" );




	}



	public static void main(String[] args) {
		testInfix2Prefix();
		testPostfix2BinaryTree();
	}

}
