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

    private void updateMovesBoard(int row, int col){
	//bod
    }

    /* do i need this, i dont think so
    private boolean addStep(int row, int col){
	if (board[row][col] != 0){
	    return false;
	} else{
	    board[row][col] = ll
	}
    }*/

    private boolean solveH(int row, int col, int level){
	int numRows = board.length;
	int numCols = board[row].length;
	// int[] ah = {12,-8,21,19,-19,-21,8,-12};
	if (numMovesBoard[row][col] == 0 && level != numRows * numCols){ //if bad square
	    return false;
	}
	
	if (level > numRows * numCols){
	    return true; // should be done
	}
        if (numMovesBoard[row][col] != 0){ //yes moves next
	    board[row][col] = level;
	    level++;
	    //how to actula do the next moves
	    if (board[row-2][col-1] != 0){ //??
	    }
	    if (board[row-2][col+1] != 0){}
	    if (board[row-1][col+2] != 0){}
	    if (board[row+1][col+2] != 0){}
	    if (board[row+2][col+1] != 0){}
	    if (board[row+2][col-1] != 0){}
	    if (board[row+1][col-2] != 0){}
	    if (board[row-1][col-2] != 0){} //also out of bounds??
	    
	}

	/*
        for (int r = row; r < numRows; r++){
	    for (int c = col; c < numCols; c++){
		//starts at designated
		if (
	    }
	    col = 0;
	    }*/
	
	/*
	00 01 02 03 04
        10 11 12 13 14
	20 21 22 23 24
        30 31 32 33 34
	*/
	return false;
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
	}
	return ans;
    }

    public static void main(String[] args){
	KnightBoard test = new KnightBoard(7,7);

	System.out.println(test.retNums());
	/*
	test.solveFast();
        System.out.println(test);*/
    }
}
