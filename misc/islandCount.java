/*
Given a 2D array binaryMatrix of 0s and 1s, implement a function
getNumberOfIslands that returns the number of islands of 1s in binaryMatrix.

An island is defined as a group of adjacent values that are all 1s. A cell in
 binaryMatrix is considered adjacent to another cell if they are next to each
 either on the same row or column. Note that two values of 1 are not part of
 the same island if they’re sharing only a mutual “corner” (i.e. they are
 diagonally neighbors).

Explain and code the most efficient solution possible and analyze its time and
space complexities.

Example:

input:  binaryMatrix = [ [0,    1,    0,    1,    0],
                         [0,    0,    1,    1,    1],
                         [1,    0,    0,    1,    0],
                         [0,    1,    1,    0,    0],
                         [1,    0,    1,    0,    1] ]

output: 6 # since this is the number of islands in binaryMatrix.
          # See all 6 islands color-coded below.
alt

Constraints:

[time limit] 5000ms

[input] array.array.int binaryMatrix

1 ≤ binaryMatrix.length ≤ 100
1 ≤ binaryMatrix[i].length ≤ 100
[output] integer
*/
import java.io.*;
import java.util.*;

class Solution {

  static int getNumberOfIslands(int[][] binaryMatrix) {
    // your code goes here
    int islands = 0;
    int rows = binaryMatrix.length;
    int cols = binaryMatrix[0].length;

    for(int i = 0; i < rows; i++){
      for(int j = 0; j < cols; j++){
        if(binaryMatrix[i][j] == 1){
          markIsland(binaryMatrix, rows, cols, i, j); // bfs starts here
          islands++;
        }
      }
    }
    return islands;
  }

 static void markIsland(int[][] binaryMatrix, int rows, int cols, int i, int j){
    Queue<int[]> q = new LinkedList<>();
    int[] curr = {i,j};
    q.add(curr);
    while(!q.isEmpty()){
      int[] item = q.remove();
      int x = item[0];
      int y = item[1];
      if(binaryMatrix[x][y] == 1){
        binaryMatrix[x][y] = -1;
        pushIfValid(q, rows, cols, x-1, y);
        pushIfValid(q, rows, cols, x, y-1);
        pushIfValid(q, rows, cols, x+1, y);
        pushIfValid(q, rows, cols, x, y+1);
      } // else it's going to be 0 or -1 which we don't care anymore at this point
    }
  }

  static void pushIfValid(Queue<int[]> q, int rows, int cols, int x, int y){
    if(x >= 0  && x < rows && y >= 0 && y < cols){ // make sure within bounds
      int[] curr = {x,y};
      q.add(curr);
    }
  }

  public static void main(String[] args) {

  }
}
