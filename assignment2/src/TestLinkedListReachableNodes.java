import assignment2.LinkedListNode;


/**
 * Testing countReachableNodes 
 *   
 * @author Igor
 *
 */

public class TestLinkedListReachableNodes {

	public static void checkEq(LinkedListNode<Character> node, int expected) {
		int ans = node.countReachableNodes();
		if (expected == ans)
			System.out.println("TestLinkedListReachableNodes from  " + node.getData() + ": checkEq Ok");
		else
			System.out.println("TestLinkedListReachableNodes from  " + node.getData() + ": checkEq Fail. "
					+ "Expected value is " + expected + ", but countReachableNodes(" + node.getData() + ")==" + ans); 
	}


	public static void main(String[] args) {
		LinkedListNode<Character> w = new LinkedListNode<Character>('W');
		LinkedListNode<Character> z = new LinkedListNode<Character>('Z', w);
		LinkedListNode<Character> y = new LinkedListNode<Character>('Y', z);
		LinkedListNode<Character> x = new LinkedListNode<Character>('X', y);
		LinkedListNode<Character> e = new LinkedListNode<Character>('E');
		LinkedListNode<Character> d = new LinkedListNode<Character>('D', e);
		LinkedListNode<Character> c = new LinkedListNode<Character>('C', d);
		LinkedListNode<Character> b = new LinkedListNode<Character>('B', c);
		LinkedListNode<Character> a = new LinkedListNode<Character>('A', b);
		e.setNext(b);
// see the pdf for a nicer picture 
//      A --> B_--> C --> D
//            |\         / 
//              \       /
//               \     /  
//                \   /
//                  E
//
//		X --> Y --> Z --> W
		
		checkEq(x, 4);
		checkEq(w, 1);
		checkEq(a, 5);
		checkEq(e, 4);
		checkEq(x, 4);
		checkEq(w, 1);

	}
}
