import java.util.Stack;

public class FrontierStack implements Frontier {
  private Stack<Location> locations;

  public FrontierStack() {
    locations = new Stack<Location>();
  }

  public void add(Location loc) {
    locations.push(loc);
  }

  public Location next() {
    return locations.pop();
  }

  // private Location get(int ind) {
  //   System.out.println("HI");
  // }

  public int size() {
    return locations.size();
  }
}
