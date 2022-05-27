

import org.junit.Test;

import static org.junit.Assert.*;


public class ArrayListConstructorTest {
	
	@Test
	public void testElementsSetCorrectly() {
		String[] data = new String[]{"a", "b", "c"};
		
		try {
			MyArrayList<String> list = new MyArrayList<>(data);
			assertTrue("MyArrayList does not correctly set elements in underlying array when input array is passed to constructor", list.get(0).equals("a"));
			assertTrue("MyArrayList does not correctly set elements in underlying array when input array is passed to constructor", list.get(1).equals("b"));
			assertTrue("MyArrayList does not correctly set elements in underlying array when input array is passed to constructor", list.get(2).equals("c"));
		}
		catch (Exception e) {
			fail("MyArrayList constructor throws exception when attempting to initialize with array: " + e.toString());
		}
	}
	
	@Test
	public void testSizeSetCorrectly() {
		String[] data = new String[]{"a", "b", "c"};
		
		try {
			MyArrayList<String> list = new MyArrayList<>(data);
			assertTrue("MyArrayList does not correctly set size when input array is passed to constructor", list.size == 3);
		}
		catch (Exception e) {
			fail("MyArrayList constructor throws exception when attempting to initialize with array: " + e.toString());
		}
	}
	
	@Test
	public void testNullInput() {
		try {
			MyArrayList<String> list = new MyArrayList<>(null);
			assertTrue("MyArrayList does not correctly initialize underlying array when null input array is passed to constructor", list.data != null);
		}
		catch (Exception e) {
			fail("MyArrayList constructor throws exception when attempting to initialize with null input array: " + e.toString());
		}
	}

	@Test
	public void testNullInputSize() {
		try {
			MyArrayList<String> list = new MyArrayList<>(null);
			assertTrue("MyArrayList does not correctly set size when null input array is passed to constructor", list.size == 0);
		}
		catch (Exception e) {
			fail("MyArrayList constructor throws exception when attempting to initialize with null input array: " + e.toString());
		}
		
	}
	
	@Test
	public void testElementsAreCopied() {
		String[] data = new String[]{"a", "b", "c"};
		
		try {
			MyArrayList<String> list = new MyArrayList<>(data);
			data[1] = "dog";
			assertFalse("MyArrayList does not make copy of elements when input array is passed to constructor", list.get(1).equals("dog"));

		}
		catch (Exception e) {
			fail("MyArrayList constructor throws exception when attempting to initialize with array: " + e.toString());
		}

		
	}
	


}
