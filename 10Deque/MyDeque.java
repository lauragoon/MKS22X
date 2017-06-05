import java.util.NoSuchElementException;

public class MyDeque {
  private String[] data;
  private int head, tail, size;

  public MyDeque() {
    data = new String[10];
    head = 0;
    tail = 0;
    size = 0;
  }

  public void addFirst(String str) {
    if (str == null) {
      throw new NullPointerException();
    }
    if (size == 0) {
      data[head] = str;
    }
    else {
      if (size == data.length) {
        doubleSize();
      }
      head = Math.floorMod(head - 1, data.length);
      data[head] = str;
    }
    size++;
  }

  public void addLast(String str) {
    if (str == null) {
      throw new NullPointerException();
    }
    if (size == 0) {
      data[tail] = str;
    }
    else {
      if (size == data.length) {
        doubleSize();
      }
      tail = Math.floorMod(tail + 1, data.length);
      data[tail] = str;
    }
    size++;
  }


  public String removeFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    String ret = data[head];
    size--;
    if (data.length - 1 == head) {
      head = 0;
    }
    else {
      head++;
    }
    return ret;
  }

  public String removeLast() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    String ret = data[tail];
    size--;
    data[tail] = null;
    if (tail == 0) {
      tail = data.length - 1;
    }
    else {
      tail--;
    }
    return ret;
  }


  public String getFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[head];
  }

  public String getLast() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[tail];
  }

  public String toString() {
    String ret = "[";
    if (size == 0) {
      ret += "]";
    }
    else {
      int i = head;
      while (i != tail) {
        ret += data[i] + ", ";
        i = Math.floorMod(i+1, data.length);
      }
      ret += data[i] + "]";
    }
    return ret;
  }


  private void doubleSize() {
    String[] hello = new String[data.length * 2];
    int ind = head;
    int ind2 = 0;
    while (ind != tail) {
      hello[ind2] = data[ind];
      ind = Math.floorMod(ind+1,data.length);
      ind2++;
    }
    hello[ind2] = data[tail];
    head = 0;
    tail = ind2;
    data = hello;
  }


}
