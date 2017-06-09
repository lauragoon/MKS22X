import java.util.*;
import java.lang.Math;

public class MazeSolver {
  private Maze board;
  private boolean animate;
  private Frontier pioneer;
  private boolean aStar;

  public MazeSolver(String filename) {
    this(filename, false); // false
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
    boolean aStar = false;
    // boolean solved = false;

    if (style == 0) {
      //DFS
      pioneer = new FrontierStack();
    }
    else if (style == 1) {
      // BFS
      pioneer = new FrontierQueue();
    }
    else if (style == 2) {
      // BEST
      pioneer = new FrontierPriorityQueue();
    }
    else if (style == 3) {
      // A*
      pioneer = new FrontierPriorityQueue();
      aStar = true;
    }
    else {
      throw new IllegalArgumentException("Invalid input: style 0-3");
    }

    // System.out.println(pioneer.size());
    // System.out.println(pioneer.get(0));

    pioneer.add(board.getStart());
    // System.out.println(pioneer.size());

    Location nextLoc;
    int curRow, curCol;
    int[] direction = {-1, 1};
    // System.out.println(pioneer.size());
    while (pioneer.size() > 0) {

      if (animate) {
        System.out.println(board.toString(100));
      }
      // System.out.println(pioneer.size());
      nextLoc = pioneer.next();
      curRow = nextLoc.getRow();
      curCol = nextLoc.getCol();

      // System.out.println("hi:()");

      if (nextLoc.getToGoal() == 0) {
        newSearching(nextLoc);
        return;
      }
      else {
        board.set(curRow,curCol,'.');
      }

      for (int num : direction) {
        int rowStartDist = Math.abs(board.getStart().getRow() - (curRow + num)) + Math.abs(board.getStart().getCol() - curCol);
        int rowEndDist = Math.abs(board.getEnd().getRow() - (curRow + num)) + Math.abs(board.getEnd().getCol() - curCol);
        int colStartDist = Math.abs(board.getStart().getRow() - curRow) + Math.abs(board.getStart().getCol() - (curCol + num));
        int colEndDist = Math.abs(board.getEnd().getRow() - curRow) + Math.abs(board.getEnd().getCol() - (curCol + num));

        if (board.get(curRow + num, curCol) != '@' && board.get(curRow + num, curCol) != '.' && board.get(curRow + num, curCol) != '#') {
          pioneer.add(new Location(curRow + num, curCol, nextLoc, rowStartDist, rowEndDist, aStar));
          board.set(curRow + num, curCol, '?');
        }
        if (board.get(curRow, curCol + num) != '@' && board.get(curRow, curCol + num) != '.' && board.get(curRow, curCol + num) != '#') {
          pioneer.add(new Location(curRow, curCol + num, nextLoc, colStartDist, colEndDist, aStar));
          board.set(curRow, curCol + num, '?');
        }
      }

    }


  }

  private void newSearching(Location loc) {
    Location me;
    int row, col;
    row = loc.getRow();
    col = loc.getCol();
    board.set(row,col,'E');
    me = loc.getPrevious();

    while (me.getToStart() > 0) { // or !=
      if (animate) {
        System.out.println(board.toString(50));
      }
      row = me.getRow();
      col = me.getCol();
      board.set(row,col,'@');
      me = me.getPrevious();
    }
    board.set(me.getRow(), me.getCol(), 'S');
    if (animate) {
      System.out.println(board.toString(50));
    }
  }


  // private int getDist(int r, int c, Location loc) {
  //   return Math.abs(r - loc.getRow()) + Math.abs(c - loc.getCol());
  // }

  // public static void main(String[] args) {
  //   MazeSolver test = new MazeSolver("data2.dat",true);
  //   test.solve(0);
  //   System.out.println(test);
  // }
}
