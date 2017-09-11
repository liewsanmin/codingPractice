import java.util.*;
import java.io.*;

/**
Given an array of sorted distinct integers named arr, write a function that returns an index i in arr for which arr[i] = i or -1 if no such index exists.

Implement the most efficient solution possible, prove the correctness of your solution and analyze its runtime complexity (in terms of n - the length of arr).

Examples:

Given arr = [-8,0,2,5] the function returns 2, since arr[2] = 2
Given arr = [-1,0,3,6] the function returns -1, since no index in arr satisfies arr[i] = i

Runtime - O(log n)
since we use a binary search where the input size is reduced in half on each step.
*/
class Solution{
    public static void main(String[] args){
        int[] arr = {-8,0,1,4,7};
        System.out.println(arrEqual(arr));
        // arrEqual(arr);
        // System.out.println("Hello World");
    }

    public static int arrEqual(int[] arr){
        int start = 0;
        int last = arr.length - 1;

        while(start <= last){
            int mid = (start + last) / 2;
            if(arr[mid] == mid)
                return mid;
            else if(arr[mid] < mid)
                start = mid + 1;
            else
                last = mid - 1;
        }
        return -1;
    }
}
// what if element are not distinct?
int magicFast(int[] array){
    return magicFast(array, 0, array.length - 1);
}

int magicFast(int[] array, int start, int end){
    if(end < start) return -1;
    int midIndex = (start + end) / 2;
    int midValue = array[midIndex];
    if(midValue == midIndex)
        return midIndex;

    // search left
    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = magicFast(array, start, leftIndex);
    if(left >= 0)
        return left;

    //search right
    int rightIndex = Math.max(midIndex + 1, midValue);
    int right = magicFast(array, rightIndex, end);

    if(right >= 0)
        return right;
}
