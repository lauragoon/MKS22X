import java.util.ArrayDeque;

public class FrontierQueue implements Frontier {
  private ArrayDeque<Location> locations;

  public FrontierQueue() {
    locations = new ArrayDeque<Location>();
  }

  public void add(Location loc) {
    locations.add(loc);
  }

  public Location next() {
    return locations.remove();
  }

  public int size() {
    return locations.size();
  }
}
