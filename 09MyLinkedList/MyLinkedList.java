import java.util.*;
import java.lang.NullPointerException;
import java.io.*;

public class MyLinkedList implements Iterable<Integer> {

  public Iterator<Integer> iterator() {
    return new MyLinkedListIterator(this);
  }

  private class MyLinkedListIterator implements Iterator<Integer> {
    private MyLinkedList li;
    private LNode now;

    public MyLinkedListIterator(MyLinkedList list) {
      li = list;
      now = head;
    }

    public boolean hasNext() {
      return now != null;
    }

    public Integer next() {
      if (hasNext()) {
        int rn = now.value;
        now = now.next;
        return rn;
      }
      else {
        throw new NoSuchElementException();
      }
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  // -~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~

  public static class LNode {
    LNode prev, next;
    int value;

    public LNode(int value) {
      this.value = value;
    }

    public String toString() { // guchi
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

  private LNode getNthNode(int n) { // guchi
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


  public void addAfter(LNode location, LNode toBeAdded) { // ----- TEST ME -----
    if (location.next == null) {
      toBeAdded.next = null;
      location.next = toBeAdded;
      toBeAdded.prev = location;
      tail = toBeAdded;
    }
    else {
      toBeAdded.next = location.next;
      location.next = toBeAdded;
      toBeAdded.prev = location;
    }
    size++;
  }

  public void remove(LNode target) {
    if (size() == 1) { // one element
      head = null;
      tail = null;
    }
    else if (target.prev == null) { // beginning
      head = target.next;
      target.next.prev = null;
    }
    else if (target.next == null) { // end
      tail = target.prev;
      target.prev.next = null;
    }
    else {
      target.prev.next = target.next;
      target.next.prev = target.prev;
    }
    size--;
  }

  public String toString() { // guchi
    String ret = "[";
    LNode now = head;
    for (int i = 0; i < size(); i++) {
      ret += now.value;
      if (i != size() - 1) {
        ret += ", ";
      }
      now = now.next;
    }
    ret += "]";
    return ret;
  }

  public String toStringDebug() { // guchi
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

  public boolean add(int value) { // guchi
    try {
      add(size,value);
      return true;
    }
    catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  public int get(int index) { // guchi
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }
    return getNthNode(index).value;
  }

  public int set(int index, int value) { // guchi
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }

    LNode me = getNthNode(index);
    int temp = me.value;

    me.value = value;

    if (index == 0) {
      head = me;
    }
    if (index == size() - 1) {
      tail = me;
    }

    return temp;
  }

  public int indexOf(int value) { // works?
    int i = 0;
    LNode me = head;

    while (me.next != null) {
      if (me.value == value) {
        return i;
      }

      me = me.next;
      i++;
    }

    if (i == size() - 1 && me.value == value) {
      return i;
    }

    return -1;
  }

  public int remove(int index) { // works
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
    }

    int ret = 0;
    if (size() == 1) {
      ret = head.value;
      head = null;
      tail = null;
    }
    else if (index == 0){
      ret = head.value;
      head = head.next;
      head.prev = null;
    }
    else if (index == size() - 1) {
      ret = tail.value;
      tail = tail.prev;
      tail.next = null;
    }
    else {
      LNode hello = getNthNode(index);
      ret = hello.value;
      hello.prev.next = hello.next;
      hello.next.prev = hello.prev;
    }

    size--;
    return ret;
  }

  public void add(int index, int value) { // guchi
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }

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

}
