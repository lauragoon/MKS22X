public interface Frontier {
    public void add(Location loc);
    public Location next();
}

// ---------

public class Location implements Comparable<Location>{
    private int row, col;
    private int distToGoal;
    private int distToStart;
    private Location previous;
    private boolean aStar;

    public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar) {
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }

    public int getRow() {
	return row;
    }
    
    public int getCol() {
	return col;
    }

    public int getToGoal() {
	return distToGoal;
    }
    
    public int getToStart() {
	return distToStart;
    }

    public int CompareTo(Location other) {
	if (aStar) {
	    return (distToStart + distToGoal) - (other.distToStart + other.distToGoal);
	}
	else {
	    return distToGoal - other.distToGoal;
	}
    }
}

// ---------

public class FrontierPriorityQueue implements Frontier {
    private PriorityQueue<Location> locations;

    public void add(Location loc) {
    }

    public Location next() {
    }
}

// ---------

public class FrontierQueue implements Frontier {
    private Queue<Location> locations;

    public void add(Location loc) {
    }

    public Location next() {
    }
}

// ---------

public class FrontierStack implements Frontier {
    private Stack<Location> locations;
    
    public void add(Location loc) {
    }

    public Location next() {
    }
}

// ---------

public class MazeSolver {
    private Maze board;
    private boolean animate;
    
    public MazeSolver(String filename) {
	this(filename,false);
    }

    public MazeSolver(String filename, boolean animate) {
	this.animate = animate;
	try {
	    Scanner.in = new Scanner(new File(filename));
	    
	}
	catch (FileNotFoundException e) {
	    System.out.println("Error: Specified file not found.");
	    System.exit(1);
	}
    }

    public void solve() {
	solve(1);
    }

    public void solve(int style) {
    }

    public String toString() {
    }
}
