public class KnightBoard{
    private int[][] board;
    private int[][] numsMovesBoard;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	for (int r = 0; r < board.length; r++){               // clear
	    for (int c = 0; c < board[r].length; c++){
		board[r][c] = 0;
	    }
	}
	//initialize the numsMovesBoard
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
	if (numMovesBoard[row][col] == 0 && level != nums * rows){ //if bad square
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

    public static void main(String[] args){
	Knightboard test = new Knightboard(7,7);
	test.solve();
	System.out.println(test);
    }
}
