/**
Write the function sudokuSolve that checks whether a given sudoku board (i.e.
sudoku puzzle) is solvable. If so, the function will returns True. Otherwise
(i.e. there is no valid solution to the given sudoku board), returns False.

In sudoku, the objective is to fill a 9x9 board with digits so that each column,
 each row, and each of the nine 3x3 sub-boards that compose the board contains
 all of the digits from 1 to 9. The board setter provides a partially completed
  board, which for a well-posed board has a unique solution. As explained above,
   for this problem, it suffices to calculate whether a given sudoku board has a
    solution. No need to return the actual numbers that make up a solution.

A sudoku board is represented in a two dimensional 9x9 array with the numbers
1,2,...,9 and blank spaces, and the function should fill the blank spaces with
 numbers such that the following rules apply:

In every row of the array, all numbers 1,2,...,9 appear exactly once.
In every column of the array, all numbers 1,2,...,9 appear exactly once.
In every 3x3 sub-board that is illustrated below, all numbers 1,2,...,9 appear
exactly once.
A solved sudoku is a board with no blank spaces, i.e. all blank spaces are
filled with numbers that abide to the constraints above. If the function
succeeds in solving the sudoku board, it'll return true (false, otherwise).

Example (more examples can be found here):

Unsolved Board
A typical Sudoku board setter	 	Solved Board
The same board with solution numbers marked in red
Write a readable an efficient code, explain how it is built and why you chose
to build it that way.

implement find possible candidates first
*/

/**
# Input:
	#	board - a sudoku board represented as a 9X9 2D array
	#	row - a row on the board
	#	col - a column on the board

    # Output:
	#	a subset of the numbers {1,2,...,9}, which may fill the index in the board
	#	without violating any of the rules described above
*/
public ArrayList<Integer> findPossibleCandidates(int[][] board, int row, i column){
    if(board == null || row < 0 || column < 0)
        return null;
    ArrayList<Integer> ans = new ArrayList<>();

    // get all values in column and row
    HashSet<Integer> numUsedInRow = new HashSet<>();
    HashSet<Integer> numUsedInColumn = new HashSet<>();
    for(int i = 0; i < 8; i++){
        numUsedInRow.add(board[row][i]);
        numUsedInColumn.add(board[i][column]);
    }

    // get all values in that sub 3x3 board
    int subBoardTopLeftRow = row - (row % 3);
    int subBoardTopLeftColumn = col - (col % 3);
    HashSet<Integer> numUsedInSubBoard = new HashSet<>();
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            numUsedInSubBoard.add(board[subBoardTopLeftRow + i][subBoardTopLeftColumn + j]);
        }
    }

    // find valid numbers and add to list
    for(int i = 1; i < 10; i++){
        boolean unique = !numUsedRow.contains(i)      &&
                         !numUsedInColumn.contains(i) &&
                         !numUsedInSubBoard.contains(i);
        if(unique)
            ans.add(i);
    }
    return ans;
}
