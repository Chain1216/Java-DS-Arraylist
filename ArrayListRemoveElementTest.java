

import org.junit.Test;

import static org.junit.Assert.*;

/*
 * Use this for grading Step 2.
 */

public class ArrayListRemoveElementTest {
	
	
    @Test
    public void testReturnValueWhenElementDoesNotExist() {
        String[] arr = new String[] {"a", "b", "c", "d", "e", "f"};
        MyArrayList<String> list = new MyArrayList<>();
        for (String e: arr) {
            list.add(e);
        }

        try {
        	boolean result = list.remove("k");
        	assertFalse("MyArrayList.remove returns incorrect value when attempting to remove element that is not in list", result);
        }
        catch (Exception e) {
        	fail("Exception occurred when trying to remove element that does not occur in list: " + e.toString());
        }
    }

    @Test
    public void testReturnValueWhenElementExists() {
        String[] arr = new String[] {"a", "b", "c", "d", "e", "f"};
        MyArrayList<String> list = new MyArrayList<>();
        for (String e: arr) {
            list.add(e);
        }

        try {
        	boolean result = list.remove("c");
        	assertTrue("MyArrayList.remove returns incorrect value when attempting to remove element that exists in list", result);
        }
        catch (Exception e) {
        	fail("Exception occurred when trying to remove element that exists in list: " + e.toString());
        }
    }
    
    @Test
    public void testSizeChangesWhenElementRemoved() {
        String[] arr = new String[] {"a", "b", "c", "d", "e", "f"};
        MyArrayList<String> list = new MyArrayList<>();
        for (String e: arr) {
            list.add(e);
        }

        try {
        	int originalSize = list.size;
        	list.remove("c");
        	assertTrue("MyArrayList.size field is not correctly modified after removing element from list", list.size == originalSize - 1);
        }
        catch (Exception e) {
        	fail("Exception occurred when trying to remove element that exists in list: " + e.toString());
        }
    }
    
    @Test
    public void testElementsInCorrectLocationsAfterElementRemoved() {
        String[] arr = new String[] {"a", "b", "c", "d", "e"};
        MyArrayList<String> list = new MyArrayList<>();
        for (String e: arr) {
            list.add(e);
        }

        try {
        	list.remove("c");
        	assertTrue("MyArrayList.remove incorrectly modifies elements in list after element is removed", list.get(0).equals("a"));
        	assertTrue("MyArrayList.remove incorrectly modifies elements in list after element is removed", list.get(1).equals("b"));

        	assertFalse("MyArrayList.remove does not correctly remove element; it still occurs in list", list.get(2).equals("c"));

        	assertTrue("MyArrayList.remove does not correctly modify elements in list after element is removed", list.get(2).equals("d"));
        	assertTrue("MyArrayList.remove does not correctly modify elements in list after element is removed", list.get(3).equals("e"));

        }
        catch (Exception e) {
        	fail("Exception occurred when trying to remove element that exists in list: " + e.toString());
        }
    }
    
    @Test
    public void testElementsInCorrectLocationsAfterDuplicateElementRemoved() {
        String[] arr = new String[] {"a", "b", "c", "b", "e"};
        MyArrayList<String> list = new MyArrayList<>();
        for (String e: arr) {
            list.add(e);
        }

        try {
        	list.remove("b");
        	
        	assertTrue("MyArrayList.remove should only remove first instance of element that occurs multiple times in list", list.get(2).equals("b"));
        }
        catch (Exception e) {
        	fail("Exception occurred when trying to remove element that exists in list more than once: " + e.toString());
        }
    }
    
    

 
}
