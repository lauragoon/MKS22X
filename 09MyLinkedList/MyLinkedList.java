import java.util.*;
import java.lang.NullPointerException;
public class MyLinkedList {

    public static class LNode {
        LNode prev, next;
        int value;

        public LNode(int value) {
            this.value = value;
        }

        public String toString() { // vvvvvvvvvv THIS WORKS vvvvvvvvvv
            //(prev)value(next)
            
            String ret = "(";
            String previous;
            String after;
            try {
                previous = Integer.toString(prev.value);
            }
            catch (NullPointerException e) {
                previous = "";
            }
            try {
                after = Integer.toString(next.value);
            }
            catch (NullPointerException e) {
                after = "";
            }
            ret += previous + ")";
            ret += Integer.toString(value) + "(";
            ret += after + ")";
            return ret;
        }
    }
    
    // -~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~

    LNode head,tail;
    int size;

    public MyLinkedList() {
	   size = 0;
    }

    public int size() {
	   return size;
    }

    private LNode getNthNode(int n) { // vvvvvvvvv think this works vvvvvvvvv
	//exception
    try {
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
    catch (NullPointerException e) {
        throw new IndexOutOfBoundsException();
    }
    }
    
    //    // JK IDK THIS DKFJSDKLFJKLSDF
    // public void addAfter(LNode location, LNode toBeAdded) { // ----- TEST ME -----
    //  // LNode temp = location;
    //	LNode temp = location.next;
    //  location.next = toBeAdded;
    //  toBeAdded.next = temp;
    //  toBeAdded.prev = location;
    //  temp.prev = toBeAdded;
    //	size++;
    //	if (location == tail) {
    //	    tail = toBeAdded;
    //	}
    //}
    
//    public void remove(LNode target) {
//	int indexRem = indexOf(target.value);
//	
//	LNode previous = getNthNode(indexRem).prev;
//	LNode after = getNthNode(indexRem).next;
//        
//        previous.next = after;
//        after.prev = previous;
//	size--;
//    }
    
    public String toString() { // vvvvvvvvv works vvvvvvvvv
        String ret = "[";
        ret += head.value + ", ";
        LNode now = head;
        while (now.next != null) {
            ret += now.next.value + ", ";
            now = now.next;
        }
        ret = ret.substring(0,ret.length()-2);
        ret += "]";
        return ret;
    }

    public String toStringDebug() { // vvvvvvvvv works vvvvvvvvv
	String ret = "[";
	ret += head.toString() + ", ";
	LNode now = head;
	while (now.next != null) {
	    ret += now.next.toString() + ", ";
	    now = now.next;
	}
	ret = ret.substring(0,ret.length()-2);
	ret += "]";
	return ret;
    }
    
    public boolean add(int value) { // vvvvvvvvv think this works vvvvvvvvv
        try {
	    add(size,value);
	    return true;
	}
	catch (IndexOutOfBoundsException e) {
	    return false;
	}
    }
    
    public int get(int index) { // vvvvvvvvv this works vvvvvvvvv
        return getNthNode(index).value;
    }
    
    public int set(int index, int value) { // ----- TEST ME -----
        int ret = getNthNode(index).value; // doesnt work if index is end
        LNode me = new LNode(value);

	if (index == 0) {
	    me.next = getNthNode(index).next);
	}
	else if (index == size-1) {
	    me.prev = getNthNode(index.prev);
	}
	else {
	}
        me.prev = getNthNode(index).prev;
        me.next = getNthNode(index).next;
        getNthNode(index).prev.next = me;
        getNthNode(index).next.prev = me;
        
        return ret;
    }
    
//    public int indexOf(int value) { // ----- TEST ME -----
//        int i = 0;
//        int ret = 0;
//        LNode me = head;
//        try {
//            while (i < size) {
//                ret = me.value;
//                me = me.next;
//                i++;
//            }
//        } catch (NullPointerException e) {
//            System.out.println("Invalid index");
//        }
//	return ret;
//    }
    
//    public int remove(int index) { // ----- TEST ME -----
//        int ret = getNthNode(index).value;
//        
//        LNode previous = getNthNode(index).prev;
//        LNode after = getNthNode(index).next;
//        
//        previous.next = after;
//        after.prev = previous;
//	size--;
//        
//        return ret;
//    }
    
    public void add(int index, int value) { // vvvvvvvvv think this works vvvvvvvvv
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	else {
	    LNode previous;
	    LNode after;
	    LNode me = new LNode(value);
	    if (index == 0) {
		after = head;
		head = me;
		if (size <= 1) {
		    tail = me;
		}
		if (size > 1) {
		    after.prev = me;
		    head.next = after;
		}
	    } 
	    else if (index == size) {
		previous = tail;
		tail = me;
		previous.next = me;
		me.prev = previous;
	    } 
	    else {
		previous = getNthNode(index).prev;
		after = getNthNode(index);
		previous.next = me;
		me.prev = previous;
		me.next = after;
		after.prev = me;
	    }
	    size++;
	}
	
	// LNode previous = getNthNode(index).prev;
	//	LNode after = getNthNode(index);
	//	LNode me = new LNode(value);
	//	previous.next = me;
	//	me.prev = previous;
	//	me.next = after;
	//	after.prev = me;
	//	size++;
	//	if (index == size) {
	//	    tail = me;
	//	}
    }



    public static void main(String[] args) {
        MyLinkedList test = new MyLinkedList();
        test.add(1);
        test.add(3);
        test.add(5);
        System.out.println(test.size());
	System.out.println(test.toStringDebug());
        test.set(2,9);
	System.out.println(test.toStringDebug());

    }


}
