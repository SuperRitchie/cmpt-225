import myiterators.*;

public class TestIterators
{

	public static void testArrayIterator() {
		int ans[] = {0,0,0,2,5,8,11,14};
		
		ArrayIterator iter = new ArrayIterator(ans);
		for (int i=0; i<ans.length; i++)
			if (!iter.hasNext() || iter.getNext() != ans[i]) {
				System.out.println("testArrayIterator Failed in iteration " + i);
				return;
			}

		if (iter.hasNext()) {
			System.out.println("testArrayIterator Failed");
			return;
		}
		
		iter.reset();
		if (!iter.hasNext() || iter.getNext() != ans[0]) {
			System.out.println("testArrayIterator Failed after reset");
			return;
		}
		
		System.out.println("testArrayIterator OK");
	}


	public static void testRangeIterator1()	{
		
		RangeIterator iter = new RangeIterator(10);
		for (int i=0; i<5; i++)
			if (!iter.hasNext() || iter.getNext() != i) {
				System.out.println("testRangeIterator1 Failed in iteration " + i);
				return;
			}

		iter.reset();
		for (int i=0; i<10; i++)
			if (!iter.hasNext() || iter.getNext() != i) {
				System.out.println("testRangeIterator1 Failed after resein iteration " + i);
				return;
			}

		if (iter.hasNext())
			System.out.println("testRangeIterator1 Failed");
		else
			System.out.println("testRangeIterator1 OK");
	}

	public static void testRangeIterator2()	{
		int ans[] = {2,5,8,11,14};

		RangeIterator iter = new RangeIterator(2,17,3);
		for (int i=0; i<ans.length; i++)
			if (!iter.hasNext() || iter.getNext() != ans[i]) {
				System.out.println("testRangeIterator2 Failed in iteration " + i);
				return;
			}

		if (iter.hasNext())
			System.out.println("testRangeIterator2 Failed");
		else
			System.out.println("testRangeIterator2 OK");
	}

	public static void testFibonacci1()	{
		int fib[] = {0,1,1,2,3,5,8,13};
		
		FibonacciIterator iter = new FibonacciIterator();
		for (int i =0; i<fib.length; i++)
			if (!iter.hasNext() || iter.getNext() != fib[i]) {
				System.out.println("testFibonacci1 Failed in iteration " + i);
				return;
			}
		System.out.println("testFibonacci1 OK");
	}

	public static void testFibonacci2() {
		int fib[] = {5,2,7,9,16,25,41};
		
		FibonacciIterator iter = new FibonacciIterator(5,2);
		for (int i=0; i<3; i++)
			if (!iter.hasNext() || iter.getNext() != fib[i]) {
				System.out.println("testFibonacci2 Failed in iteration " + i);
				return;
			}

		iter.reset();
		for (int i=0; i<fib.length; i++)
			if (!iter.hasNext() || iter.getNext() != fib[i]) {
				System.out.println("testFibonacci2 Failed after reset in iteration " + i);
				return;
			}

		if (iter.hasNext())
			System.out.println("testFibonacci2 OK");
		else
			System.out.println("testFibonacci2 Failed");
	}

	public static void main(String[] args) {
		testArrayIterator();
		testRangeIterator1();
		testRangeIterator2();
		testFibonacci1();
		testFibonacci2();
		
	}
}