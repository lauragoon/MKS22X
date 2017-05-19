public class FrontierQueue implements Frontier {
    private Queue<Location> locations;

    public FrontierQueue() {
	locations = new Queue()<Location>;
    }

    public void add(Location loc) {
	locations.add(loc);
    }

    public Location next() {
	locations.remove();
    }
}

