public class FrontierPriorityQueue implements Frontier {
    private Queue<Location> locations;
    
    public FrontierPriorityQueue() {
        locations = new Queue<Location>();
    }
    
    public void add(Location loc) {
    }

    public Location next() {
        locations.remove();
    }
}

