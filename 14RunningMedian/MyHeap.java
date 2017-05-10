import java.util.*;

public class MyHeap {
  private ArrayList<Integer> heap;
  private int constant;

  public MyHeap() { // max heap
    heap = new ArrayList<Integer>();
    constant = 1;
    heap.add(null);
  }

  public MyHeap(boolean bool) {
    heap = new ArrayList<Integer>();
    heap.add(null);
    if (bool) { // max heap
      constant = 1;
    }
    else { // min heap
      constant = -1;
    }
  }

  public void add(Integer n) {
    heap.add(n);
    pushUp(1);
  }

  public Integer remove() {
    swap(1,size());
    Integer rem = heap.remove(size());
    pushDown(1);
    return rem;
  }

  public Integer peek() {
    if (size() >= 1) {
      return heap.get(1);
    }
    return null;
  }

  public String toString() {
    String ret = "";
    for (Integer str : heap) {
      ret += str + " ";
    }
    return ret;
  }

  public void swap(int a, int b) {
    Integer temp = heap.get(a);
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

  private int compare(Integer a, Integer b) {
    return constant * a.compareTo(b);
  }


}
