public class MazeSolver {
    private Maze board;
    private boolean animate;
    
    public MazeSolver(String filename) {
	this(filename,false);
    }

    public MazeSolver(String filename, boolean animate) {
	this.animate = animate;
        board = new Maze(filename);
    }

    public void solve() {
	solve(1);
    }

    public void solve(int style) {
	Frontier pioneer;
	if (style == 0) {
	    //DFS
	    pioneer = new FrontierStack();
	}
	else if (style == 1) {
	    // BFS
	    pioneer = new FrontierQueue();
	}
	else if (style == 2) {
	    // BEST FIRST
	    pioneer = new FrontierPriorityQueue();
	}
	else if (style == 3) {
	    // A*
	    
	}
	else {
	    // no
	}
    }

    public String toString() {
    }
}
