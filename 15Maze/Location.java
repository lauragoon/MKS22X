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
