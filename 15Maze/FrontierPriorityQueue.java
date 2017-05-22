public class FrontierPriorityQueue implements Frontier {
  private MyHeap locations;

  public FrontierPriorityQueue() {
    locations = new MyHeap();
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
