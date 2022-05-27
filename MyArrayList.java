/*
 * I attest that the code in this file is entirely my own except for the starter
 * code provided with the assignment and the following exceptions:
 * <
 * Enter all external resources and collaborations here. Note external code may
 * reduce your score but appropriate citation is required to avoid academic
 * integrity violations. Please see the Course Syllabus as well as the
 * university code of academic integrity:
 *  https://catalog.upenn.edu/pennbook/code-of-academic-integrity/
 * >
 * Signed,
 * Author: Zhaoqin Wu
 * Penn email: <zhaoqinw@seas.upenn.edu>
 * Date: <2022-05-24>
 */

public class MyArrayList<E> {

    /*
     * Do not change this initial capacity; it is used by our test cases
     */
    private static final int INITIAL_CAPACITY = 4;

    /*
     * These are protected so that test cases can access them. Please do not change
     * the visibility of these fields!
     */
    protected Object[] data;
    protected int size = 0;

    public MyArrayList() {
        data = (E[]) new Object[INITIAL_CAPACITY];
 
    }

    /*
     * Need to implement this in step 5
     */
    public MyArrayList(E[] arr) {
    	if (arr == null || arr.length == 0 ) {
    		data = (E[]) new Object[INITIAL_CAPACITY];
    	} else {
    	this.size = arr.length;
    	data = (E[]) new Object[Math.max(arr.length,INITIAL_CAPACITY)];
    	for (int i = 0; i < arr.length; i++) {
    		data[i] = arr[i];
    	}

    		
    }	
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else
            return (E) data[index];
    }

    private void increaseCapacity() {
        String[] newData = new String[Math.max(2 * data.length, INITIAL_CAPACITY)];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /*
     * This method adds the element to the list. Except for modifying it to use Java
     * Generics, DO NOT OTHERWISE CHANGE THIS METHOD as it is used in testing your
     * code.
     */
    public void add(E value) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size++] = value;
    }

    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            increaseCapacity();
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
         E target =  (E) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        /* Shrink array when it is too large
         */
        if(size <= data.length/4.0) {      
        	E[] new_data = (E[]) new Object[data.length/2];
        	for (int i = 0; i < size; i++) {
        		new_data[i] = (E) data[i];
        		this.data = new_data;
        	}
        	
        }
        
        return target;
    }

    /*
     * Need to implement this in Step 2.
     * Remove element by value
     */
    public boolean remove(E obj) {
    	for (int i = 0; i < size; i++) {
    		if (data[i] == obj) {
    			for (int k = i; k < size-1; k++) {
    				data[k] = data[k+1];
    				
    	}  		
    	/* Shrink array when it is too large
    	 */
    			size--;
    			data[size] = null;
    			if(size <= data.length/4.0) {      
    	        	E[] new_data = (E[]) new Object[data.length/2];
    	        	for (int p = 0; p < size; p++) {
    	        		new_data[p] = (E) data[p];
    	        		this.data = new_data;
    	        }	
    	        }
    			return true;	
    	}	
    	}
    	
        return false;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + data[i]);
        }
    }

    public boolean contains(E obj) {
        for (int i = 0; i < size; i++) {
            if (obj == data[i] || (data[i] != null && data[i].equals(obj)))
                return true;
        }
        return false;
    }

    /*
     * Need to implement this in Step 4
     */
    public E set(int index, E obj) {
    	if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    	
    	E replaced = (E) data[index];
    	data[index] = obj;
    	
        return replaced;
    }

}