public class FrontierStack implements Frontier {
    private Stack<Location> locations;

    public FrontierStack() {
	locations = new Stack()<Location>;
    }
    
    public void add(Location loc) {
	locations.push(loc);
    }

    public Location next() {
	locations.pop();
    }
}

