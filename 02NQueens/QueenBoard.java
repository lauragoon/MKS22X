public class QueenBoard{
  private int[][] board;
  private int solutionCount;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
    if (board[r][c] != 0){ //already queen or threatened
      return false;
    }
    board[r][c] = -1;
    for (int row = 0; row < board[r].length; row++){ //changes thratened squares
      for (int col = 0; col < board.length; col++){
        if (row == r || col == c){ //check if this double coutns some
          board[row][col] += 1;
        }
      }
    }
    return true;
  }

  private boolean removeQueen(int r, int c){
    if (board[r][c] != -1){
      return false;
    }
    board[r][c] = 0;
    for (int row = 0; row < board.length; row++){ //changes unthratened squares
      for (int col = 0; col < board[0].length; col++){
        if (row == r || col == c){ //check if this double coutns some
          board[row][col] -= 1;
        }
      }
    }
  }

/**
  *precondition: board is filled with 0's only.
  *@return false when the board is not solveable. true otherwise.
  *postcondition:
  *if false: board is still filled with 0's
  *if true: board is filled with the
  *final configuration of the board after adding
  *all n queens. Uses solveH
  */
  public void solve(){
    return solveH(0);
  }

  private boolean solveH(int col){
    return false; //change
  }

  public void countSolutions(){

  }

/**
  *@return the number of solutions found, or -1 if the board was never solved.
  *The board should be reset after this is run.
  */
  public int getCount(){
    return -1; // change
  }

/**toString
  *and all nunbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  */
  public String toString(){
    String ret = "";
    for (int row = 0; row < board.length; row++){
      for (int col = 0; col < board[0].length; col++){
        ret += board[row][col] + "\t"; //rem \t???
      }
      ret += "\n";
    }
    return ret;
  }

  //testing ------
  // public static void main(String[] args){
  //   QueenBoard test = new QueenBoard(8);
  //   System.out.println(test);
  //   System.out.println(test.solve());
  //   System.out.println(test);
  // }

}
