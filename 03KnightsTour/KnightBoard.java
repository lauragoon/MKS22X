public class KnightBoard{
  private int[][] board;

  public KnightBoard(int startingRows, int startingCols){
    board = new int[startingRows][startingCols];

    for (int r = 0; r < board.length; r++){               // clear
      for (int c = 0; c < board[0].length; c++){
        board[r][c] = 0;
      }
    }
  }


  private boolean solveH(int row, int col, int level){
    int numRows = board.length;
    int numCols = board[0].length;

    if (level > numRows * numCols){
      return true; // should be done
    }


    try{
      if (board[row][col] != 0){ // if already went on path
        return false;
      }
    } catch (IndexOutOfBoundsException e){ // then no more
      return false;
    }

    // pass the checks
    board[row][col] = level;
    level++;

    // if next move is not avail
    if (!(solveH(row-2,col-1,level) || solveH(row-2,col+1,level) || solveH(row-1,col+2,level) || solveH(row+1,col+2,level) ||
          solveH(row+2,col+1,level) || solveH(row+2,col-1,level) || solveH(row+1,col-2,level) || solveH(row-1,col-2,level))){
        board[row][col] = 0; // take it back!!
        return false;
      }

      return true; // passes it all and possible
    }

  public void solve(){
    solveH(0,0,1);
  }

  public String toString(){
    String ans = "";
    for (int r = 0; r < board.length; r++){
      for (int c = 0; c < board[r].length; c++){
        if (board[r][c] < 10){
          ans += " " + Integer.toString(board[r][c]) + " ";
        } else{
          ans += Integer.toString(board[r][c]) + " ";
        }
      }
      ans += "\n";
    }
    return ans;
  }

}
