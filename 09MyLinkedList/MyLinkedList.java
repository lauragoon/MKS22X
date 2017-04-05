import java.util.*;
import java.lang.NullPointerException;
public class MyLinkedList {

    public static class LNode {
        LNode prev, next;
        int value;

        public LNode(int value) {
            this.value = value;
        }

        public String toString() { //(prev)value(next) ----- TEST ME -----
            String ret = "(";
            ret += prev.value + ")";
            ret += value + "(";
            ret += next.value + ")";
            return ret;
        }
	/*
	public static void main(String[] args) {
	LNode a = new LNode(1);
	LNode b = new LNode(3);
	LNode c = new LNode(6);
        a.next = b;
	b.next = c;
	b.prev = a;
	c.prev = b;
	System.out.println(a.toString());
	System.out.println(b.toString());
	System.out.println(c.toString());
	System.out.println("hi");
	}*/
    }
    
    // -~-~-~-~-~-~-~-~-~-~

    LNode head,tail;
    int size;

    public MyLinkedList() {
	   size = 0;
    }

    public int size() {
	   return size;
    }

    private LNode getNthNode(int n) { // ----- TEST ME -----
	//exception
	LNode me;
	if (size-n < size/2) { //start at end
	    me = tail;
	    int i = size;
	    while (i > n) {
		  me = me.prev;
          i--;
	    }
	}
	else { // start at beginning
	    me = head;
	    int i = 0;
	    while (i < n) {
		  me = me.next;
          i++;
	    }
	}
	return me;
    }
    
    // JK IDK THIS DKFJSDKLFJKLSDF
    public void addAfter(LNode location, LNode toBeAdded) { // ----- TEST ME -----
        // LNode temp = location;
	LNode temp = location.next;
        location.next = toBeAdded;
        toBeAdded.next = temp;
        toBeAdded.prev = location;
        temp.prev = toBeAdded;
	size++;
	if (location == tail) {
	    tail = toBeAdded;
	}
    }
    
    public void remove(LNode target) {
	int indexRem = indexOf(target.value);
	
	LNode previous = getNthNode(indexRem).prev;
	LNode after = getNthNode(indexRem).next;
        
        previous.next = after;
        after.prev = previous;
	size--;
    }
    
    public String toString() { // ----- TEST ME -----
        String ret = "[";
        ret += head.value + ", ";
        LNode now = head;
        while (now.next != null) {
            ret += now.next.value + ", ";
            now = now.next;
        }
        ret = ret.substring(0,ret.length()-1);
        ret += "]";
        return ret;
    }
    
    public boolean add(int value) { // ----- MAKE ME PLEASE -----
        // make value into node
        // use add(index,value)
	LNode me = new LNode(value);
	tail.next = me;
	me.prev = tail;
	size++;
	tail = me;
	return true;
    }
    
    public int get(int index) { // ----- TEST ME -----
        return getNthNode(index).value;
    }
    
    public int set(int index, int value) { // ----- TEST ME -----
        int ret = getNthNode(index).value;
        
        LNode me = new LNode(value);
        me.prev = getNthNode(index).prev;
        me.next = getNthNode(index).next;
        getNthNode(index).prev.next = me;
        getNthNode(index).next.prev = me;
        
        return ret;
    }
    
    public int indexOf(int value) { // ----- TEST ME -----
        int i = 0;
        int ret = 0;
        LNode me = head;
        try {
            while (i < size) {
                ret = me.value;
                me = me.next;
                i++;
            }
        } catch (NullPointerException e) {
            System.out.println("Invalid index");
        }
	return ret;
    }
    
    public int remove(int index) { // ----- TEST ME -----
        int ret = getNthNode(index).value;
        
        LNode previous = getNthNode(index).prev;
        LNode after = getNthNode(index).next;
        
        previous.next = after;
        after.prev = previous;
	size--;
        
        return ret;
    }
    
    public void add(int index, int value) { // ----- TEST ME -----
        LNode previous = getNthNode(index).prev;
	LNode after = getNthNode(index);
	LNode me = new LNode(value);
	previous.next = me;
	me.prev = previous;
	me.next = after;
	after.prev = me;
	size++;
	if (index == size) {
	    tail = me;
	}
    }



    public static void main(String[] args) {
	/*
	MyLinkedList test = new MyLinkedList();
	test.add(1);
	test.add(3);
	test.add(5);
	System.out.println(test.size());
	*/
	LNode a = new LNode(1);
	LNode b = new LNode(3);
	LNode c = new LNode(6);
        a.next = b;
	b.next = c;
	b.prev = a;
	c.prev = b;
	System.out.println(a.toString());
	System.out.println(b.toString());
	System.out.println(c.toString());
    }


}
