import java.util.*;
import java.lang.Math;

public class MazeSolver {
  private Maze board;
  private boolean animate;
  private Frontier pioneer;

  public MazeSolver(String filename) {
    this(filename, false);
  }

  public MazeSolver(String filename, boolean animate) {
    this.animate = animate;
    board = new Maze(filename);
  }

  public String toString() {
    return board.toString();
  }

  public void solve() {
    solve(1);
  }

  public void solve(int style) {
    // boolean aStar = false;
    boolean solved = false;

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
      pioneer = new FrontierPriorityQueue();
      // aStar = true;

    }
    // 	else {
    // 	    // no
    // 	}

    // Location cur = board.getStart();
    //  while (pioneer.size() == 0 || Math.abs(pioneer.next().compareTo(board.getEnd())) > 0) {
    //   newSearching(cur, aStar);
    //   board.set(cur.getRow(), cur.getCol(), '.');
    //   cur = pioneer.next();
    // }

    pioneer.add(board.getStart());
    while (pioneer.size() > 0) {
      // see if done
      if (animate) {
        System.out.println(board.toString(110));
      }
      Location next = front.next();
      if (next.getToGoal() == 0) {
        solved = true;
        // stuff
      }
    }
  }

  private void newSearching(Location loc, boolean aStar) {
     int[] values = {1,0,-1,0,0,1,0,-1};
     for (int i = 0; i < 8; i += 2) {
       if (board.get(loc.getRow() + values[i], loc.getCol() + values[i+1]) != '.' && board.get(loc.getRow() + values[i], loc.getCol() + values[i+1]) != '#') {
         Location adding = new Location(loc.getRow() + values[i],
                                        loc.getCol() + values[i+1],
                                        loc,
                                        getDist(loc.getRow() + values[i], loc.getCol() + values[i+1], board.getStart()),
                                        getDist(loc.getRow() + values[i], loc.getCol() + values[i+1], board.getEnd()),
                                        aStar);
         pioneer.add(adding);
       }
     }
  }

  private int getDist(int r, int c, Location loc) {
    return Math.abs(r - loc.getRow()) + Math.abs(c - loc.getCol());
  }

  public static void main(String[] args) {
    String filename = args[0];
    int method = Integer.parseInt(args[1]);
    MazeSolver solver = new MazeSolver(filename);
    System.out.println(solver.board);
    System.out.println(solver.pioneer);
    System.out.println(solver.board.getStart().compareTo(solver.board.getEnd()));
    solver.solve(method);
  }
}
