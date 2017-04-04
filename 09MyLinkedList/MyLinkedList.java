import java.util.*;
public class MyLinkedList {

    private class LNode {
	LNode prev, next;
	int value;
	
	public LNode(int value) {
	    this.value = value;
	}
	
	public String toString() {
	    String ret = "(";
	    ret += prev.value + ")";
	    ret += value + "(";
	    ret += next.value + ")";
	    return ret;
	}
    }

    private LNode head,tail;
    private int size;

    public MyLinkedList() {
	size = 0;
    }

    public int size() {
	return size;
    }

    private LNode getNthNode(int n) {
	//exception
	LNode me;
	if (size-n < size/2) { //start at end
	    me = tail;
	    int i = size;
	    while (i > n) {
		me = me.prev;
	    }
	}
	else {
	    me = head;
	    int i = 0;
	    while (i < n) {
		me = me.next;
	    }
	}
	return me;
    }


    // --------------------------------

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

    public int get(int index) {
	return -1;
    }

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


}
