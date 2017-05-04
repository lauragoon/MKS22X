import java.util.ArrayList;

public class MyHeap {
    private ArrayList<String> heap;

    public MyHeap() { // max heap
	heap = new ArrayList<String>();
    }

    public MyHeap(boolean bool) {
	if (bool) { // max heap
	    MyHeap();
	}
	else { // min heap
	    heap = new ArrayList<String>();
	}
    }

    public void add(String s) {
    }

    public String remove() {
    }

    public String peek() {
    }

    
    private void pushUp() {
	
    }

    private void pushDown() {
    }
}
