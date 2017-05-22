import java.util.*;

public class MyHeap {
  private ArrayList<Location> heap;
  private int size;
  private boolean mode;

  public MyHeap() {
    heap = new ArrayList<Location>();
    heap.add(new Location());
    size = 0;
    mode = true;
  }

  // public MyHeap(boolean bool) {
  //   heap = new ArrayList<Location>();
  //   heap.add(new Location());
  //   size = 0;
  //   mode = bool;
  // }

  public void add(Location s) {
    heap.add(s);
    size++;
    pushUp();
  }

  public Location remove() {
    Location ret;
    if (size == 1) {
      ret = heap.remove(size);
    }
    else {
      ret = heap.set(1, heap.remove(size));
    }
    size--;
    pushDown();
    return ret;
  }

  public Location peek() {
    return heap.get(1);
  }

  public String toString() {
    return heap.toString();
  }

  // public void swap(int a, int b) {
  //   String temp = heap.get(a);
  //   heap.set(a,heap.get(b));
  //   heap.set(b,temp);
  // }

  public int size() {
    return size;
  }

  private void pushUp() {
    int ind = size;

    while (ind > 1 && heap.get(ind).compareTo(heap.get(ind / 2)) > 0) {
      Location t = heap.set(ind, heap.get(ind / 2));
      heap.set(ind / 2, t);
      ind /= 2;
    }

  }

  private void pushDown() {
    int ind = 1;
    boolean isNotDone = true;
    while (ind * 2 < size && isNotDone) {
      int leftSide = heap.get(ind).compareTo(heap.get(ind * 2));
      int rightSide = heap.get(ind).compareTo(heap.get(ind * 2 + 1));
      if (leftSide > 0 && rightSide > 0) {
        isNotDone = false;
      }
      else if (leftSide < rightSide) {
        Location t = heap.set(ind, heap.get(ind * 2 + 1));
        heap.set(ind * 2 + 1, t);
        ind = ind * 2 + 1;
      }
      else {
        Location t = heap.set(ind, heap.get(ind * 2));
        heap.set(ind * 2, t);
        ind *= 2;
      }
    }
  }

  // private int compare(String a, String b) {
  //   return constant * a.compareTo(b);
  // }


}
