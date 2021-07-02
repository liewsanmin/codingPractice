/*
Number of Paths

You’re testing a new driverless car that is located at the Southwest
(bottom-left) corner of an n×n grid. The car is supposed to get to the opposite,
 Northeast (top-right), corner of the grid. Given n, the size of the grid’s
 axes, write a function numOfPathsToDest that returns the number of the possible
  paths the driverless car can take.

alt the car may move only in the white squares

For convenience, let’s represent every square in the grid as a pair (i,j). The
first coordinate in the pair denotes the east-to-west axis, and the second
coordinate denotes the south-to-north axis. The initial state of the car is
(0,0), and the destination is (n-1,n-1).

The car must abide by the following two rules: it cannot cross the diagonal
border. In other words, in every step the position (i,j) needs to maintain
i >= j. See the illustration above for n = 5. In every step, it may go one
square North (up), or one square East (right), but not both. E.g. if the car
is at (3,1), it may go to (3,2) or (4,1).

Explain the correctness of your function, and analyze its time and space
complexities.

Example:

input:  n = 4

output: 5 # since there are five possibilities:
          # “EEENNN”, “EENENN”, “ENEENN”, “ENENEN”, “EENNEN”,
          # where the 'E' character stands for moving one step
          # East, and the 'N' character stands for moving one step
          # North (so, for instance, the path sequence “EEENNN”
          # stands for the following steps that the car took:
          # East, East, East, North, North, North)
Constraints:

[time limit] 5000ms

[input] integer n

1 ≤ n ≤ 100
[output] integer
*/
import java.io.*;
import java.util.*;

/*
time - O(n^2)
space - O(1)
*/
class Solution {
/// recursive ///
 static int numOfPathsToDest(int n) {
    int[][] memo = new int[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++)
        memo[i][j] = -1;
    }

    return numOfPathsToSquare(n-1, n-1, memo);
  }

  static int numOfPathsToSquare(int i,int j,int[][] memo){
    if(i < 0 || j < 0) // edge cases
      return 0;
    else if(i < j) // the given invariant
      memo[i][j] = 0;
    else if(memo[i][j] != -1) // return when it is saved
      return memo[i][j];
    else if(i == 0 && j == 0) // add one when reach the end
      memo[i][j] = 1;
    else
      memo[i][j] = numOfPathsToSquare(i, j-1, memo) +
                   numOfPathsToSquare(i-1, j, memo);
    return memo[i][j];
  }

  /// iterative ///
  static int numOfPathsToDest(int n){
    if(n == 1)
      return 1;
    int[] lastRow = new int[n];
    for(int i = 1; i < n; i++){
      lastRow[i] = 1; // base case - the first row is all ones
    }
    int[] currentRow = new int[n];

    for(int j = 1; j < n; j++){
      for(int i = j; i < n; i++){
        if(i == j)
          currentRow[i] = lastRow[i];
        else
          currentRow[i] = currentRow[i-1] + lastRow[i];
          lastRow = currentRow;
      }
    }
    return currentRow[n-1];
  }

  public static void main(String[] args) {

  }

}
