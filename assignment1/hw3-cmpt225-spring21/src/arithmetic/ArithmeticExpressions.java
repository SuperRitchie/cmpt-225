package arithmetic;

import java.util.*;

import binarytree.BTNode;

public class ArithmeticExpressions {

	final public static int PLUS = 0;
	final public static int MINUS = 1;
	final public static int MULT = 2;
	final public static int DIV = 3;
	static final List<String> opsStr = Arrays.asList("+", "-", "*", "/");

	public static boolean isOperation(String str) {
		return opsStr.contains(str);
	}

	public static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * converts infix notation to prefix notation
	 * @param infixExpression
	 * @return
	 */
	public static String infix2Prefix(String infixExpression) {
		// TODO implement me
		return null;
	}

	/**
	 * converts postfix notation to binary tree representation of an arithmetic expression
	 * @param infixExpression
	 * @return
	 */
	public static BTNode<Double> postfix2BinaryTree(String postfixExpression) {
		// TODO implement me
		return null;
	}
}
