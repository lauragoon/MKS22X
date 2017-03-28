public class MyLinkedList {
    private LNode start;
    private int size;

    public MyLinkedList() {
	start = null; // extra??
	size = 0;
    }

    private LNode getNthNode(int n) {
	for (int i = 0; i < n; i++) {
	    
	}
    }

    /* adds the value to end (try adding to the front first, for testing purposes) */
    public boolean add(int n) {
	LNode current = start;
	LNode end = new LNode();
	end.value = n;
	//if (size > 0) {
	for (int i = 0; i < size; i++) {
	    current = current.next;
	}
	    //	}
	current.next = end;
	/*
	while (current.next != null) {
	    current = current.next;
	}
	current.next = end;
	*/
	size++;
	return true;
    }

    /* return the number of elements in the list */
    public int size() {
	return size;
    }

    /* returns a string representation of the list of n elements formatted like: 
       [ v0, v1, v2, v3, ... vn-1] 
       An empty list is just []
    */
    public String toString() {
	String ret = "[ ";
	LNode current = start;
	for (int i = 0; i < size; i++) {
	    ret += Integer.toString(current.value) + ", ";
	}
	/*
	ret += Integer.toString(start.value) + ", ";
	while (current.next != null) {
	    current = current.next;
	    ret += Integer.toString(current.value) + ", ";
	}
	*/
	ret = ret.substring(0,ret.length()-1);
	ret += "]";
	return ret;
    }

    /* return the value of the element at the specified index (0 based) */
    public int get(int index) {
	return -1;
    }

    /* change the value of the element at the specified index to the newValue, return the old value */
    public int set(int index, int newValue) {
	return -1;
    }

    public static void main(String[] args) {
	MyLinkedList test = new MyLinkedList();
	test.add(1);
	test.add(3);
	test.add(5);
	System.out.println(test.size());
	System.out.println(test.toString());
    }

    private class LNode {
        public int value;
	public LNode next;
    }
}
