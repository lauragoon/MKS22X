import java.util.*;

public class FrontierQueue implements Frontier {
  private ArrayDeque<Location> locations;

  public FrontierQueue() {
    locations = new ArrayDeque<Location>();
  }

  public void add(Location loc) {
    locations.add(loc);
  }

  // private Location get(int ind) {
  //   System.out.println("HI");
  // }

  public Location next() {
    try {
      return locations.remove();
    }
    catch (NoSuchElementException e) {
      throw new NoSuchElementException("No elements");
    }
  }

  public int size() {
    return locations.size();
  }
}
