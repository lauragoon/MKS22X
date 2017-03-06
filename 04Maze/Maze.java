import java.util.*;
import java.io.*;

public class Maze{
  private char[][] maze;
  private boolean animate;
  private int rows;
  private int cols;

  /*Constructor loads a maze text file, and sets animate to false by default.
  1. The file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - locations that cannot be moved onto
  ' ' - locations that can be moved onto
  'E' - the location of the goal (exactly 1 per file)

  'S' - the location of the start(exactly 1 per file)

  2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
  3. When the file is not found OR there is no E or S then: print an error and exit the program.

  */

  public Maze(String filename){
    int r = 0;
    int c = 0;
    ArrayList<String> inputs = new ArrayList<String>();
    boolean startReq = true;
    boolean endReq = true;
    animate = false;

    try {
      Scanner in = new Scanner(new File(filename));
      // String line = in.nextLine();
      // numCols = line.length();
      while (in.hasNextLine()){
        r++;
        String line = in.nextLine();
        inputs.add(line);
      }
      c = inputs.get(0).length();

      rows = r;
      cols = c;
      maze = new char[rows][cols];
      // System.out.println(rows);
      // System.out.println(cols);

      for (int row = 0; row < rows; row++){
        for (int col = 0; col < cols; col++){
          maze[row][col] = inputs.get(row).charAt(col);
          if (maze[row][col] == 'S'){
            startReq = false;
          }
          if (maze[row][col] == 'E'){
            endReq = false;
          }
        }
      }
      if (startReq || endReq){
        System.out.println("Error: No start or end");
        System.exit(1);
      }
    } catch (FileNotFoundException e){
      System.out.println("Error: Specified file not found.");
      System.exit(1);
    }
  }


  private void wait(int millis){ //ADDED SORRY!
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }


  public void setAnimate(boolean b){
    animate = b;
  }


  public void clearTerminal(){
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
  }



  /*Wrapper Solve Function
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  public boolean solve(){
    int startr=-1,startc=-1;

    //Initialize starting row and startint col with the location of the S.
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++){
        if (maze[r][c] == 'S'){
          startr = r;
          startc = c;
        }
      }
    }

    maze[startr][startc] = ' ';//erase the S, and start solving!
    return solve(startr,startc);
  }

  /*
  Recursive Solve function:

  A solved maze has a path marked with '@' from S to E.

  Returns true when the maze is solved,
  Returns false when the maze has no solution.


  Postcondition:

  The S is replaced with '@' but the 'E' is not.

  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
  private boolean solve(int row, int col){
    if(animate){
      System.out.println("\033[2J\033[1;1H"+this);
      wait(20);
    }

    if (maze[row][col] == 'E'){
      return true; //yay it done!!!! whoooo

    } else if (maze[row][col] == '#' || maze[row][col] == '.' || maze[row][col] == '@'){
      return false; //bad possibilities

    } else {
      maze[row][col] = '@'; //assume right at first

      if (solve(row+1,col) || solve(row-1,col) || solve(row,col-1) || solve(row,col+1)){
        // clearTerminal();
        return true; //at least one works!! yay

      } else {
        maze[row][col] = '.'; //aww it didnt work....
      }
    }

    return false; //so it compiles
  }

  public String toString(){
    String ans = "";
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++){
        ans += maze[r][c];
      }
      ans += "\n";
    }
    return ans;
  }

}
