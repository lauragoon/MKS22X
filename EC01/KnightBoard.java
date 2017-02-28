public class KnightBoard{
  private int[][] board;
  private int[][] numMovesBoard;

  public KnightBoard(int startingRows, int startingCols){
    board = new int[startingRows][startingCols];

    for (int r = 0; r < board.length; r++){               // clear
      for (int c = 0; c < board[0].length; c++){
        board[r][c] = 0;
      }
    }

    numMovesBoard = new int[startingRows][startingCols];
    makeNumBoard();
  }

  public void makeNumBoard(){
    int numRows = numMovesBoard.length;
    int numCols = numMovesBoard[0].length;

    for (int r = 0; r < numRows; r++){
      for (int c = 0; c < numCols; c++){
        if (r == 0 || r == numRows - 1){
          if ((c == 0 || c == numCols - 1) && numMovesBoard[r][c] == 0){
            numMovesBoard[r][c] = 2;
          }
          if ((c == 1 || c == numCols - 2) && numMovesBoard[r][c] == 0){
            numMovesBoard[r][c] = 3;
          }
          else if (numMovesBoard[r][c] == 0){
            numMovesBoard[r][c] = 4;
          }
        }
        if (r == 1 || r == numRows - 2){
          if ((c == 0 || c == numCols - 1) && numMovesBoard[r][c] == 0){
            numMovesBoard[r][c] = 3;
          }
          if ((c == 1 || c == numCols - 2) && numMovesBoard[r][c] == 0){
            numMovesBoard[r][c] = 4;
          }
          else if(numMovesBoard[r][c] == 0) {
            numMovesBoard[r][c] = 6;
          }
        }
        else {
          if ((c == 0 || c == numCols - 1) && numMovesBoard[r][c] == 0){
            numMovesBoard[r][c] = 4;
          }
          if ((c == 1 || c == numCols - 2) && numMovesBoard[r][c] == 0){
            numMovesBoard[r][c] = 6;
          }
          else if(numMovesBoard[r][c] == 0) {
            numMovesBoard[r][c] = 8;
          }
        }
      }
    }
  }

  public String retNums(){
    String ans = "";
    for (int r = 0; r < numMovesBoard.length; r++){
      for (int c = 0; c < numMovesBoard[0].length; c++){
        if (numMovesBoard[r][c] < 10){
          ans += " " + Integer.toString(numMovesBoard[r][c]) + " ";
        } else{
          ans += Integer.toString(numMovesBoard[r][c]) + " ";
        }
      }
      ans += "\n";
    }
    return ans;
  }


private void updateMoves(int row, int col, int change){
  try {
    if (numMovesBoard[row-2][col-1] != 0){
      numMovesBoard[row-2][col-1] += change;
    }
  } catch (ArrayIndexOutOfBoundsException e){
    ;
  }
  try {
    if (numMovesBoard[row-2][col+1] != 0){
      numMovesBoard[row-2][col+1] += change;
    }
  } catch (ArrayIndexOutOfBoundsException e){
    ;
  }
  try {
    if (numMovesBoard[row-1][col+2] != 0){
      numMovesBoard[row-1][col+2] += change;
    }
  } catch (ArrayIndexOutOfBoundsException e){
    ;
  }
  try {
    if (numMovesBoard[row+1][col+2] != 0){
      numMovesBoard[row+1][col+2] += change;
    }
  } catch (ArrayIndexOutOfBoundsException e){
    ;
  }
  try {
    if (numMovesBoard[row+2][col+1] != 0){
      numMovesBoard[row+2][col+1] += change;
    }
  } catch (ArrayIndexOutOfBoundsException e){
    ;
  }
  try {
    if (numMovesBoard[row+2][col-1] != 0){
      numMovesBoard[row+2][col-1] += change;
    }
  } catch (ArrayIndexOutOfBoundsException e){
    ;
  }
  try {
    if (numMovesBoard[row+1][col-2] != 0){
      numMovesBoard[row+1][col-2] += change;
    }
  } catch (ArrayIndexOutOfBoundsException e){
    ;
  }
  try {
    if (numMovesBoard[row-1][col-2] != 0){
      numMovesBoard[row-1][col-2] += change;
    }
  } catch (ArrayIndexOutOfBoundsException e){
    ;
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
  int hold = numMovesBoard[row][col];
  numMovesBoard[row][col] = 0;
  updateMoves(row,col,-1);
  board[row][col] = level;
  level++;

  // if next move is not avail
  if (numMovesBoard[row-2][col-1] == 0 && numMovesBoard[row-2][col+1] == 0 && numMovesBoard[row-1][col+2] == 0 && numMovesBoard[row+1][col+2] == 0 &&
        numMovesBoard[row+2][col+1] == 0 && numMovesBoard[row+2][col-1] == 0 && numMovesBoard[row+1][col-2] == 0 && numMovesBoard[row-1][col-2] == 0){
      board[row][col] = 0; // take it back!!
      numMovesBoard[row][col] = hold;
      updateMoves(row,col,1);
      return false;
    }


<<<<<<< HEAD
	System.out.println(test.retNums()); //prints numMoveBoard
	/*
	test.solveFast();
        System.out.println(test);*/
=======

    return true; // passes it all and possible
  }

  public void solveFast(){
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
>>>>>>> 2a9d886545b687c5980a3f92b81248623142127c
    }
    return ans;
  }

  public static void main(String[] args){
    KnightBoard test = new KnightBoard(7,7);

    // System.out.println(test.retNums());

    test.solveFast();
    System.out.println(test);
  }
      }
