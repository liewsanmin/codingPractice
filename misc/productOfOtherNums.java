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

public class Solution {
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] array){
        if(array.length < 2)
            throw new IllegalArgumentException("Requires at least array of size 2");

        int productSoFar = 1;
        int[] answer = new int[array.length];
        for(int i = 0; i < array.length; i++){
            answer[i] = productSoFar;
            productSoFar *= array[i];

        }

        productSoFar = 1;
        for(int j = array.length - 1; j >= 0; j--){
            answer[j] *= productSoFar;
            productSoFar *= array[j];

        }
        return answer;

    }
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
		int[] array = {1,7,3,4};
        int[] ans = getProductsOfAllIntsExceptAtIndex(array);
        for(int curr : ans){
            System.out.print(curr + " ");
        }


    }
}
