
import mystack.MyStack;
import assignment2.MyStackOperations;
import java.awt.Point;


/**
 * Testing MyStackOperations
 *   
 * @author Igor
 *
 */

public class TestMyStackOperations {
	
	public static int count=1;
	
	public static void checkSize(int expected, int actual) {
		if (expected == actual)
			System.out.println("TestMyStackOperations " + count + ": checkEq Ok");
		else
			System.out.println("TestMyStackOperations " + count + ": checkEq Fail. "
					+ "Expected size = " + expected +" but .size() returned " + actual);
		count++;
	}
	
	
	public static void checkPoint(Point expected, Point actual) {
		if (expected.equals(actual))
			System.out.println("TestMyStackOperations " + count + ": checkEq Ok");
		else
			System.out.println("TestMyStackOperations " + count + ": checkEq Fail");
		count++;
	}
	
	public static void main(String[] args) {
		
		MyStack<Point> s = new MyStack<Point>();
		checkSize(0, MyStackOperations.size(s));
		s.push(new Point(2,3));
		s.push(new Point(1,2));
		s.push(new Point(1,4));
		checkSize(3, MyStackOperations.size(s));
		s.push(new Point(1,2));
		s.push(new Point(6,8));
		s.push(new Point(1,2));
		s.push(new Point(3,2));
		s.push(new Point(1,4));
		s.push(new Point(5,10));
		
		checkSize(9, MyStackOperations.size(s));

		Point pt0 = s.pop();
		checkSize(8, MyStackOperations.size(s));
		checkPoint(new Point(5,10), pt0);

		
		MyStackOperations.reverse(s);
		Point pt1 = s.pop();
		checkSize(7, MyStackOperations.size(s));

		checkPoint(new Point(2,3), pt1);
		
		MyStack<Point> t = MyStackOperations.cloneStack(s);
		checkSize(7, MyStackOperations.size(s));
		checkSize(7, MyStackOperations.size(t));

		Point pt2 = t.pop();
		checkPoint(new Point(1,2), pt2);

		checkSize(7, MyStackOperations.size(s));
		checkSize(6, MyStackOperations.size(t));

		MyStackOperations.reverse(t);
		s.pop();
		checkSize(6, MyStackOperations.size(s));
		checkSize(6, MyStackOperations.size(t));

	}
}