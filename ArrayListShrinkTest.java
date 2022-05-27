

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListShrinkTest {
	
	@Test
	public void testRemoveByIndex() {
        String[] arr = new String[] {"a", "b", "c", "d", "e", "f"};
        MyArrayList<String> list = new MyArrayList<>();
        for (String e: arr) {
            list.add(e);
        }
        
        // elements = 6, length = 8
        
        try {
        	list.remove(1); // elements = 5, length should still be 8
        	assertTrue("MyArrayList.remove(int) incorrectly shrinks array when number of elements is greater than 25% of array size", ((Object[])list.data).length == 8);
        	list.remove(1); // elements = 4, length should still be 8
        	assertTrue("MyArrayList.remove(int) incorrectly shrinks array when number of elements is greater than 25% of array size", ((Object[])list.data).length == 8);
        	list.remove(1); // elements = 3, length should still be 8
        	assertTrue("MyArrayList.remove(int) incorrectly shrinks array when number of elements is greater than 25% of array size", ((Object[])list.data).length == 8);
        	list.remove(1); // elements = 2, length should now be 4
        	assertTrue("MyArrayList.remove(int) does not shrink array when number of elements is 25% of array size", ((Object[])list.data).length == 4);
        	
        }
        catch (Exception e) {
        	fail("MyArrayList.remove(int) throws exception when attempting to remove element by index: " + e.toString());
        }
		
	}
	
	@Test
	public void testRemoveByValue() {
        String[] arr = new String[] {"a", "b", "c", "d", "e", "f"};
        MyArrayList<String> list = new MyArrayList<>();
        for (String e: arr) {
            list.add(e);
        }
        
        // elements = 6, length = 8
        
        try {
        	list.remove("b"); // elements = 5, length should still be 8
        	assertTrue("MyArrayList.remove(E) incorrectly shrinks array when number of elements is greater than 25% of array size", ((Object[])list.data).length == 8);
        	list.remove("c"); // elements = 4, length should still be 8
        	assertTrue("MyArrayList.remove(E) incorrectly shrinks array when number of elements is greater than 25% of array size", ((Object[])list.data).length == 8);
        	list.remove("d"); // elements = 3, length should still be 8
        	assertTrue("MyArrayList.remove(E) incorrectly shrinks array when number of elements is greater than 25% of array size", ((Object[])list.data).length == 8);
        	list.remove("e"); // elements = 2, length should now be 4
        	assertTrue("MyArrayList.remove(E) does not shrink array when number of elements is 25% of array size", ((Object[])list.data).length == 4);
        	
        }
        catch (Exception e) {
        	fail("MyArrayList.remove(E) throws exception when attempting to remove element by index: " + e.toString());
        }
		
	}

}
