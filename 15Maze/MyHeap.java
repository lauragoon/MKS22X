import java.util.*;

public class MyHeap {
  public ArrayList<Location> heap; // private
  private int size;
  private boolean mode;

  public MyHeap() {
    heap = new ArrayList<Location>();
    heap.add(new Location()); // new Location()
    size = 0;
    mode = true;
  }

  public MyHeap(boolean mode) {
    heap = new ArrayList<Location>();
    heap.add(new Location());
    size = 0;
    this.mode = mode;
  }


  public void add(Location s) {
    heap.add(s);
    size++;
    pushUp(size); // or use getter?
  }

  public Location remove() {
    Location ret;
    if (size == 2) {
      ret = heap.remove(size);
    }
    else {
      // ret = heap.set(1, heap.remove(size));
      Location temp = heap.remove(size - 1);
      ret = peek();
      heap.set(1,temp);
    }
    size--;
    pushDown(1);
    return ret;
  }

  public Location peek() {
    return heap.get(1);
  }

  public String toString() {
    return heap.toString();
  }

  public void swap(int a, int b) {
    Location temp = heap.get(a);
    heap.set(a,heap.get(b));
    heap.set(b,temp);
  }

  public int size() {
    return size;
  }

  // public int size() {
  //   return heap.size() - 1;
  // }

  private void pushDown(int ind) {
    if (mode) {
      pushDownMax(ind);
    }
    else {
      pushDownMin(ind);
    }
  }

  private void pushDownMax(int ind) {
    if (ind * 2 >= size) {
      return;
    }
    else {
      try {
        int max = getMaxMin(true,ind);
        if (max != ind) {
          swap(max, ind);
          pushDownMax(max);
        }
      }
      catch (IndexOutOfBoundsException e) {
        if (heap.get(ind).compareTo(heap.get(2 * ind)) < 0) {
          swap(ind, 2 * ind);
          pushDownMax(2 * ind);
        }
      }
    }
  }

  public Location get(int ind) {
    return heap.get(ind);
  }

  private void pushDownMin(int ind) {
    if (2 * ind >= size) {
      return;
    }
    else {
      try {
        int min = getMaxMin(false,ind);
        if (min != ind) {
          swap(min,ind);
          pushDownMin(min);
        }
      }
      catch (IndexOutOfBoundsException e) {
        if (heap.get(ind).compareTo(heap.get(2 * ind)) > 0) {
          swap(ind,2 * ind);
          pushDownMin(2 * ind);
        }
      }
    }
  }

  private void pushUp(int ind) {
    if (mode) {
      pushUpMax(ind);
    }
    else {
      pushUpMin(ind);
    }
  }

  private void pushUpMax(int ind) {
    if (ind == 1) {
      return;
    }
    else {
      int topper = ind / 2;
      if (heap.get(ind).compareTo(heap.get(topper)) > 0) {
        swap(topper, ind);
        pushUpMax(topper);
      }
    }
  }

  private void pushUpMin(int ind) {
    if (ind == 1) {
      return;
    }
    else {
      int topper = ind / 2;
      if (heap.get(ind).compareTo(heap.get(topper)) < 0) {
        swap(topper, ind);
        pushUpMin(topper);
      }
    }
  }

  private int getMaxMin(boolean isMax, int ind) {
    int first = 2 * ind;
    int second = ind + 1;
    int ret = ind;

    int firstCompare = heap.get(ret).compareTo(heap.get(first));
    int secondCompare = heap.get(ret).compareTo(heap.get(second));

    if (isMax) {
      if (firstCompare < 0) {
        ret = first;
      }
      if (secondCompare < 0) {
        ret = second;
      }
    }
    else {
      if (firstCompare > 0) {
        ret = first;
      }
      if (secondCompare > 0) {
        ret = second;
      }
    }
    return ret;
  }


}
