import java.util.ArrayList;

public class MyHeap {
  private ArrayList<String> heap;
  private int constant;
  private int size;

  public MyHeap() { // max heap
    heap = new ArrayList<String>();
    constant = 1;
    size = 1;
    heap.add(0,"n/a");
    // heap.add("");
  }

  public MyHeap(boolean bool) {
    if (bool) { // max heap
      heap = new ArrayList<String>();
      constant = 1;
      size = 1;
      heap.add(0,"n/a");
    }
    else { // min heap
      heap = new ArrayList<String>();
      constant = -1;
      size = 1;
      heap.add(0,"n/a");
    }
  }

  public void add(String s) {
    heap.add(s);
    size++;
    pushUp(size-1);
  }

  public String remove() {
    String rem = heap.get(1);
    heap.set(1,heap.get(size));
    heap.remove(size);
    pushDown(1);
    size--;
    return rem;
  }

  public String peek() {
    return heap.get(1);
  }

  public String toString() {
    String ret = "";
    for (String str : heap) {
      ret += str + " ";
    }
    return ret;
  }


  private void pushUp(int index) {
      System.out.println(size);
      System.out.println(index);
    String a = heap.get(index);
    String b = heap.get(index * 2);
    if (!(a.compareTo(b)*constant < 0 || index == size)) {
      String temp = heap.get(index/2);
      heap.set(index/2,heap.get(index));
      heap.set(index,temp);
      pushUp(index / 2);
    }
  }

  private void pushDown(int index) {
    String a = heap.get(index);
    String b = heap.get(index * 2);
    if (!(a.compareTo(b)*constant < 0 || index == size)) {
      String temp = heap.get(index*2);
      heap.set(index*2,heap.get(index));
      heap.set(index,temp);
      pushDown(index * 2);
    }
  }


  public static void main(String[] args) {
    MyHeap test = new MyHeap();
    test.add("a");
    test.add("p");
    test.add("o");
    System.out.println(test);
  }
}
