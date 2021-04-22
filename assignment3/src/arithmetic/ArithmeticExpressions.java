package arithmetic;

import java.util.*;

import binarytree.BTNode;

public class ArithmeticExpressions {

	final public static int PLUS = 0;
	final public static int MINUS = 1;
	final public static int MULT = 2;
	final public static int DIV = 3;
	Vector<String> vec = new Vector<String>();
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

	/*
	public static String reverse(String str) {
		String ans = "";
		String add = "";
		boolean adding = false;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				ans = ')' + ans;
			}
			else if(str.charAt(i) == ')') {
				ans = '(' + ans;
			}
			else if(str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' ||
					str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' || str.charAt(i) == '7' ||
					str.charAt(i) == '8' || str.charAt(i) == '9' || str.charAt(i) == '.') {
				add = add + str.charAt(i);
				adding = true;
			}
			else if(adding) {
				ans = " " + add + ans;
				add = "";
				adding = false;
			}
			else {
				ans = str.charAt(i) + ans;
			}
		}
		return ans;
	}
	*/

	public static String reverse(String initStr)
	{
		int length = initStr.length();
		char[] temp = initStr.toCharArray();

		for(int i = 0;  i < length; i++ )
		{
			temp[i] = initStr.charAt((length - i - 1));
		}

		String reversed = String.valueOf(temp);
		return reversed;
	}
	/*
	public static Vector<Double> store(String str) {
		String add = "";
		boolean adding = false;
		Vector<String> vec = new Vector<String>();
		Vector<Double> doubleForm = new Vector<Double>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '0' || str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' ||
					str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' || str.charAt(i) == '7' ||
					str.charAt(i) == '8' || str.charAt(i) == '9' || str.charAt(i) == '.') {
				add = add + str.charAt(i);
				adding = true;
			}
			else if(adding) {
				vec.addElement(add);
				add = "";
				adding = false;
			}
		}

		for(int i = 0; i < vec.size(); i++) {
			doubleForm.addElement(Double.parseDouble(vec.get(i)));
		}
		return doubleForm;
	}
	*/

	////////////////////////////////////////////////////
	public static String strConvert(String initStr) {
		int length = initStr.length();
		String charCombine = "";
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < length; i++) {
			char currChar = initStr.charAt(i);
			if (currChar == '+' || currChar == '-' || currChar == '/' || currChar == '*') {
				stack.push(currChar);
			}

			if (Character.isDigit(currChar)) {
				charCombine += currChar;
				if (i != length - 1) {
					char next = initStr.charAt(i + 1);
					if(next == ' ') {
						charCombine += ' ';
					}
				}
			}

			if (currChar == '.') {
				charCombine += currChar;
			}

			if (currChar == ')') {
				stack.push(currChar);
			}

			if (currChar == '(' ) {
				while (stack.peek() != ')') {
					charCombine += stack.pop();
					charCombine += ' ';
				}
				stack.pop();
			}
		}

		while(!stack.isEmpty())
		{
			charCombine += stack.pop();
		}
		String reverseStr = (reverse(charCombine));
		String ans = "";

		for(int i = 1; i < reverseStr.length(); i++)
		{
			ans += reverseStr.charAt(i);
		}
		return ans;
	}

	public static String infix2Prefix(String infixExpression) {
		return strConvert(reverse(infixExpression));
	}

	/**
	 * converts postfix notation to binary tree representation of an arithmetic expression
	 * @param infixExpression
	 * @return
	 */


	public static BTNode<Double> postfix2BinaryTree(String postfixExpression) {
		int length = postfixExpression.length();

		Stack<String> stackPoint = new Stack<>();

		char[] arrChar = new char[length];

		for(int i = 0; i < postfixExpression.length(); i++)
		{
			arrChar[i] = postfixExpression.charAt(i);
		}

		int position = 0;
		String numberString = "";
		// Initial numberString to be concatenated to

		for(int j = 0; j < length; j++) {
			if (arrChar[j] == ' ') {
				for (int k = position; k < j; k++) {
					numberString += arrChar[k];
				}
				position = j + 1;
				stackPoint.push(numberString);
				numberString = "";
			}

			else if ( j == length - 1)
			{
				for (int k = position; k < j + 1; k++) {
					numberString += arrChar[k];
				}
				stackPoint.push(numberString);
			}
		}

		Stack<String> doubleValue = new Stack<>();

		while(!stackPoint.isEmpty()) {
			doubleValue.push(stackPoint.pop());
		}
		stackPoint = doubleValue;

		String tempStr = "";

		Stack<BTNode<Double>> setStack = new Stack<>();
		while(!stackPoint.isEmpty()) {
			tempStr = stackPoint.pop();
			char tempInitial = tempStr.charAt(0);

			if(Character.isDigit(tempStr.charAt(0))){
				double token = Double.parseDouble(tempStr);
				BTNode<Double> leafNode = new BTNode<Double>(token);
				setStack.push(leafNode);
			}
			else if(tempInitial == '*'){
				BTNode<Double> operatorNode = new BTNode<Double>((double) MULT);
				operatorNode.setRightChild(setStack.pop());
				operatorNode.setLeftChild(setStack.pop());

				setStack.push(operatorNode);
			}

			else if(tempInitial == '-'){
				BTNode<Double> operatorNode = new BTNode<Double>((double) MINUS);
				operatorNode.setRightChild(setStack.pop());
				operatorNode.setLeftChild(setStack.pop());

				setStack.push(operatorNode);
			}

			else if(tempInitial == '/'){
				BTNode<Double> operatorNode = new BTNode<Double>((double) DIV);
				operatorNode.setRightChild(setStack.pop());
				operatorNode.setLeftChild(setStack.pop());

				setStack.push(operatorNode);
			}

			else if(tempInitial == '+'){
				BTNode<Double> operatorNode = new BTNode<Double>((double) PLUS);
				operatorNode.setRightChild(setStack.pop());
				operatorNode.setLeftChild(setStack.pop());
				setStack.push(operatorNode);
			}
		}
		BTNode<Double> rootNode = setStack.pop();
		return rootNode;
	}
}
