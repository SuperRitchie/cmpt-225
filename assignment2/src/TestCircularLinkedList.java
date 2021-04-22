import assignment2.CircularLinkedList;


/**
 * Testing circular linked list
 *   
 * @author Igor
 *
 */

public class TestCircularLinkedList {
	public static int count=1;
	
	public static void checkEq(String expected, String actual) {
		if (expected.equals(actual))
			System.out.println("TestCircularLinkedList " + count + ": checkEq Ok");
		else
			System.out.println("TestCircularLinkedList " + count + ": checkEq Fail");
		count++;
	}
	
	public static void checkIsEmpty(boolean expected, boolean actual) {
		if (expected == actual)
			System.out.println("TestCircularLinkedList " + count + ": checkIsEmpty Ok");
		else
			System.out.println("TestCircularLinkedList " + count + ": checkIsEmpty Fail");
		count++;
	}
	
	public static void main(String[] args) {
		
		CircularLinkedList<String> cycle = new CircularLinkedList<String>();
		checkIsEmpty(true, cycle.isEmpty());
		cycle.addAfter("A");	//[A] 		pointer is on A
		checkEq("A", cycle.getValue());
		cycle.addAfter("B");	//[A,B] 	pointer is on A
		checkEq("A", cycle.getValue());
		checkIsEmpty(false, cycle.isEmpty());
		cycle.moveForward();	//[A,B] 	pointer is on B
		checkEq("B", cycle.getValue());
		cycle.addAfter("C");	//[A,B,C] 	pointer is on B
		checkEq("B", cycle.getValue());
		cycle.moveForward();	//[A,B,C] 	pointer is on C
		checkEq("C", cycle.getValue());
		cycle.moveBackward();	//[A,B,C]	pointer is on B
		checkEq("B", cycle.getValue());
		cycle.addAfter("D");	//[A,B,D,C]	pointer is on B
		checkEq("B", cycle.getValue());
		cycle.moveForward();	//[A,B,D,C] pointer is on D
		checkEq("D", cycle.getValue());
		cycle.moveForward();	//[A,B,D,C] pointer is on C
		checkEq("C", cycle.getValue());
		checkIsEmpty(false, cycle.isEmpty());
		cycle.setValue("X");	//[A,B,D,X] pointer is on X
		checkEq("X", cycle.getValue());
		cycle.removeAfter();	//[B,D,X] 	pointer is on X
		checkEq("X", cycle.getValue());
		cycle.removeBefore();	//[B,X] 	pointer is on X
		checkEq("X", cycle.getValue());
		cycle.moveForward();	//[B,X] 	pointer is on B
		checkIsEmpty(false, cycle.isEmpty());
		checkEq("B", cycle.getValue());
		cycle.removeAfter();	//[B] 		pointer is on B
		cycle.removeAfter();	//[] 		pointer == null 
		checkIsEmpty(true, cycle.isEmpty());
	}
}
