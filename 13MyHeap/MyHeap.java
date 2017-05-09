import java.util.*;

public class MyHeap {
  private ArrayList<String> heap;
  private int constant;

  public MyHeap() { // max heap
    heap = new ArrayList<String>();
    constant = 1;
    heap.add(null);
  }

  public MyHeap(boolean bool) {
    heap = new ArrayList<String>();
    heap.add(null);
    if (bool) { // max heap
      constant = 1;
    }
    else { // min heap
      constant = -1;
    }
  }

  public void add(String s) {
    heap.add(s);
    pushUp(1);
  }

  public String remove() {
    swap(1,size());
    String rem = heap.remove(size());
    pushDown(1);
    return rem;
  }

  public String peek() {
    if (size() > 1) {
      return heap.get(1);
    }
    return null;
  }

  public String toString() {
    String ret = "";
    for (String str : heap) {
      ret += str + " ";
    }
    return ret;
  }

  public void swap(int a, int b) {
    String temp = heap.get(a);
    heap.set(a,heap.get(b));
    heap.set(b,temp);
  }

  public int size() {
    return heap.size() - 1;
  }

  private void pushUp(int index) {
    while (index > 1 && compare(heap.get(index),heap.get(index/2)) > 0) {
      swap(index,index/2);
      index /= 2;
    }
  }

  private void pushDown(int index) {
    int biggerSide = -999;
    while (index*2 < size() && (compare(heap.get(index),heap.get(index*2)) < 0 || compare(heap.get(index),heap.get(index*2+1)) < 0)) {
      if (compare(heap.get(index*2),heap.get(index*2+1)) >= 0) {
        biggerSide = index * 2;
      }
      else {
        biggerSide = index*2 + 1;
      }
      swap(index,biggerSide);
      index = biggerSide;
    }
  }

  private int compare(String a, String b) {
    return constant * a.compareTo(b);
  }


}
