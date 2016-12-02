/**
Given an array of integers arr, write a function that returns another array at the same
length where the value at each index i is the product of all array values except arr[i].

Solve without using division and analyze the runtime and space complexity

Example: given the array [2, 7, 3, 4]
your function would return: [84, 24, 56, 42] (by calculating:
[7*3*4, 2*3*4, 2*7*4, 2*7*3])


brute : O(n^2) get all combinations except that one in another array

optimze : 1 array, one forward, products except that one
          second time multiply backwards
          time - O(n)
          space -O(n)
          edge null input and length == 1
*/

public class Solution{
    public static void main(String[] args){
        int[] arr = {1,2,3};
        //           6 0 0
        int[] ans = productOfOtherNums(arr);
        for(int curr : ans){
            System.out.print(curr + " ");
        }
        System.out.println();
    }

    public static int[] productOfOtherNums(int[] arr){
        if(arr.length == 1)
            return null;
        int arrLen = arr.length;
        // [1 2 3]
        /**

        currProd = 2
        */
        // forwardArr [1 1 2]
        int[] forwardArr = new int[arrLen];
        int currProd = 1;
        for(int i = 0; i < arrLen; i++){
            forwardArr[i] = currProd;
            currProd *= arr[i];
        }

        /**
        currProd = 6
        forwardArr[6 3 2]
        */
        currProd = 1;
        for(int i = arrLen - 1; i >= 0; i--){
            forwardArr[i] *= currProd;
            currProd *= arr[i];
        }

        return forwardArr;
    }
}
