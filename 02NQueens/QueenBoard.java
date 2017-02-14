public class QueenBoard{
  private int[][] board;
  private int solutionCount;

  public QueenBoard(int size){
    if (size <= 0){
      throw new IllegalArgumentException();
    }
    board = new int[size][size];
    solutionCount = -1;
    for (int r = 0; r < board.length; r++){ //clears
      for (int c = 0; c < board[0].length; c++){
        board[r][c] = 0;
      }
    }
  }

  private boolean addQueen(int r, int c){
    if (board[r][c] != 0){ //already queen or threatened
      return false;
    }
    board[r][c] = -1;
    for (int row = 0; row < board.length; row++){
      for (int col = 0; col < board[row].length; col++){
        if ((row == r || col == c || Math.abs(row - r) == Math.abs(col - c)) && board[row][col] != -1){
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
    // board[r][c] = 0;
    for (int row = 0; row < board.length; row++){
      for (int col = 0; col < board[row].length; col++){
        if ((row == r || col == c || Math.abs(row - r) == Math.abs(col - c)) && board[row][col] != -1){
          board[row][col] -= 1;
        }
      }
    }
    board[r][c] = 0; // gotta be in end
    return true;
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
    for (int r = 0; r < board.length; r++){ //clears
      for (int c = 0; c < board[0].length; c++){
        board[r][c] = 0;
      }
    }
    solveH(0);
  }

  private boolean solveH(int col){
    int size = board.length;
    if (size <= 3){
      return false;
    }
    if (col >= size){ //if reach this point, it should be done
      return true;
    }
    for (int row = 0; row < size; row++){
      if (addQueen(row, col)){
        // addQueen(row,col);
        if (solveH(col+1)){
          return true;
        } else{
          removeQueen(row, col);
        }
      }
    }
    return false;
  }

  public void countSolutions(){
    solutionCount = 0; //bc it ran now
    for (int r = 0; r < board.length; r++){ //clears
      for (int c = 0; c < board[0].length; c++){
        board[r][c] = 0;
      }
    }
    solutionH(0);
  }

  private boolean solutionH(int col){
    int size = board.length;
    if (size <= 3){
      solutionCount = 0; //or just do nothing?
      return true;
    }
    if (col >= size){ //if reach this point, it should be done
      solutionCount += 1;
      return true;
    }
    for (int row = 0; row < size; row++){
      if (addQueen(row, col)){
        solutionH(col + 1);
        removeQueen(row, col);
        // addQueen(row,col);
    //     if (solveH(col+1)){
    //       return true;
    //     } else{
    //       removeQueen(row, col);
    //     }
      }
    }
    return true;
  }

  /**
  *@return the number of solutions found, or -1 if the board was never solved.
  *The board should be reset after this is run.
  */
  public int getSolutionCount(){
    return solutionCount;
  }

  /**toString
  *and all nunbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  */
  public String toString(){
    String ret = "";
    for (int row = 0; row < board.length; row++){
      for (int col = 0; col < board[0].length; col++){
        //ret += board[row][col] + " ";
        if (board[row][col] == -1){
          ret += "Q ";
        } else {
          ret += "_ ";
        }
      }
      ret += "\n";
    }
    return ret;
  }

  // //testing ------
  // public static void main(String[] args){
  //   QueenBoard test = new QueenBoard(6);
  //   //	System.out.println(test);
  //   test.solve();
  //   System.out.println(test);
  //   // test.countSolutions();
  //   // System.out.println(test.getSolutionCount());
  // }

}
