public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	for (int r = 0; r < board.length; r++){               // clear
	    for (int c = 0; c < board[r].length; c++){
		board[r][c] = 0;
	    }
	}
    }

    /* do i need this
    private boolean addStep(int row, int col){
	if (board[row][col] != 0){
	    return false;
	} else{
	    board[row][col] = ll
	}
    }*/

    private boolean solveH(int row, int col, int level){
	int numRows = board.length;
	int numCols = board[0].length;
	// int[] ah = {12,-8,21,19,-19,-21,8,-12};
	
	if (level > numRows * numCols){
	    return true; // should be done
	}
	while (level <= numRows * numCols){
	    
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
	Knightboard test = new Knightboard(5,5);
	test.solve();
	System.out.println(test);
    }
}
