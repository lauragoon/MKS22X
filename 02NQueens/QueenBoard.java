public class QueenBoard{
    private int[][] board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	solutionCount = -1;
    }

    private boolean addQueen(int r, int c){
	if (board[r][c] != 0){ //already queen or threatened
	    return false;
	}
	board[r][c] = -1;
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board[0].length; col++){
		if (row == r || 
		    col == c || 
		    Math.abs((row+col)-(r+c)) == 9 || 
		    Math.abs((row+col)-(r+c)) == 11){ //check if this double coutns some
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
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board[0].length; col++){
		if (row == r || 
		    col == c || 
		    Math.abs((row+col)-(r+c)) == 9 || 
		    Math.abs((row+col)-(r+c)) == 11){ //check if this double coutns some
		        board[row][col] -= 1;
		}
	    }
	}
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
	if (board.length <= 3){
	    //?? a blank board
	}
	solveH(0);
    }

    private boolean solveH(int col){
	int size = board.length;
	if (col == size){ //if reach this point, it should be done
	    return true;
	}
	for (int row = 0; row < size; row++){
	    if (addQueen(row, col)){
		System.out.println(Array.toString(board)); //debug
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
	//clear board
	int size = board.length;
	    for (int col = 0; col < board[0].length; col++){
		if (col == size){ //if reach this point, it should be done
		    solutionCount++;
		}
		for (int row = 0; row < size; row++){
		    if (addQueen(row, col)){
			//does it do it in the boolean?? test later
			if (solveH(col+1)){
			    solutionCount++;
			} else{
			    removeQueen(row, col);
			}
		    }
		}
		//solutionCount += 0;
	    }
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.
     */
    public int getCount(){
	return solutionCount; // i think this is how it works
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

    //testing ------
    public static void main(String[] args){
	QueenBoard test = new QueenBoard(5);
	//	System.out.println(test);
	test.solve();
	System.out.println(test);
    }

}
