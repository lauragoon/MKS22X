import java.util.NoSuchElementException;

public class FrontierPriorityQueue implements Frontier {
  private MyHeap locations;

  public FrontierPriorityQueue() {
    locations = new MyHeap(false); // boolean
  }

  public void add(Location loc) {
    locations.add(loc);
  }

  // private Location get(int ind) {
  //   return locations.get(ind);
  // }

  public Location next() {
    // try {
      return locations.remove();
    // }
    // catch (IndexOutOfBoundsException e) {
    //   throw new NoSuchElementException("No elements");
    // }
  }

  public int size() {
    return locations.size();
  }
}
