/**
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
*/
class Solution{
    public static void main(String[] args){
        int[][] arr = {{1}};
        if(search2DMatrix(arr, 0))
            System.out.println("found");
        else
            System.out.println("not found");
    }
    
    /**
    O(log m*n) -- time
    */
    public boolean searchMatrix(int[][] matrix, int target) {
            int start = 0;
            int row = matrix.length;
            int column = matrix[0].length;
            int last = row * column - 1;

            while(start <= last){
                int mid = (start + last) / 2;
                int x = mid / column;
                int y = mid % column;

                if(matrix[x][y] ==  target)
                    return true;
                else if(target > matrix[x][y])
                    start = mid + 1;
                else
                    last = mid - 1;
            }
            return false;
        }
    }
    
    /**
    O(m+n) -- time
    */
    public boolean searchStepWise(int[][] matrix, int target){
        int row = matrix.length;
        int column = matrix[0].length;
        if(matrix[0][0] > target || matrix[row - 1][column - 1] < target)
            return false;
        
        // start from top right since top right is larget in first row
        int x = 0;
        int y = column - 1;
        while(x < row && y >= 0){
            if(matrix[x][y] == target)
                return true;
            else if(target > matrix[x][y]) // move down
                x++;
            else
                y--; // move left
        }
        return false;
    }
}
