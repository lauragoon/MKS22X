public class MazeSolver {
    private Maze board;
    private boolean animate;
    private Frontier pioneer;
    
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
	if (style == 0) {
	    //DFS
	    pioneer = new FrontierStack();
	}
	if (style == 1) {
	    // BFS
	    pioneer = new FrontierQueue();
	}
	if (style == 2) {
	    // BEST FIRST
	    pioneer = new FrontierPriorityQueue();
	}
	if (style == 3) {
	    // A*
	    pioneer = new FrontierPriorityQueue();
	    
	}
// 	else {
// 	    // no
// 	}
    }

    public String toString() {
    }
}
