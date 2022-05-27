

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListSetTest {
	
	MyArrayList<String> list = null;
	
	@Before
	public void setUp() {
    	String[] arr = {"a", "b", "c", "d", "e"};
    	list = new MyArrayList<>();
    	list.data = arr;
    	list.size = arr.length;	
	}

	
    @Test(timeout = 1000)
    public void testThreeElementList() {
        try {
            MyArrayList<String> list2 = new MyArrayList<>();
            list2.add("hi");
            list2.add("bye");
            list2.add(null);
            list2.add("last");
            assertEquals(list2.size, 4);
        } catch (Exception e) {
            fail("MyArrayList.add does not appear to properly modify size. Expected list of 3 elements plus a null value");
        }
    }
    
    
	@Test
	public void testReturnValue() {
		try {
			String ret = list.set(2, "dog");
			assertTrue("MyArrayList.set does not return correct value when attempting to set element with valid index", ret.equals("c"));
		}
		catch (Exception e) {
			fail("MyArrayList.set throws exception when attempting to set element with valid index: " + e.toString());
		}
	}
	
	@Test
	public void testElementReplaced() {
		try {
			list.set(2, "cat");
			assertTrue("MyArrayList.set does not correctly replace value when attempting to set element with valid index", list.get(2).equals("cat"));
		}
		catch (Exception e) {
			fail("MyArrayList.set throws exception when attempting to set element with valid index: " + e.toString());
		}
	}
	
	


    @Test
    public void testSetNegativeIndex() {
    	try {
    		list.set(-5, "cat");
    		// made it here but shouldn't have!
    		fail("MyArrayList.set does not throw exception when called with negative index");
    	}
    	catch (IndexOutOfBoundsException e) {
    		// this is expected!
    	}
    	catch (Exception e) {
    		fail("Incorrect exception (" + e + ") thrown when calling MyArrayList.set with negative index");
    	}
    }
    
    @Test
    public void testSetLargeIndex() {
    	try {
    		list.set(400, "cat");
    		// made it here but shouldn't have!
    		fail("MyArrayList.set does not throw exception when called with index that is too large");
    	}
    	catch (IndexOutOfBoundsException e) {
    		// this is expected!
    	}
    	catch (Exception e) {
    		fail("Incorrect exception (" + e + ") thrown when calling MyArrayList.set with index that is too large");
    	}
    }

}
