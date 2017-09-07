/*
Pancake Sort

Given an array of integers arr:

Write a function flip(arr, k) that reverses the order of the first k elements in
 the array arr.
Write a function pancakeSort(arr) that sorts and returns the input array. You
are allowed to use only the function flip you wrote in the first step in order
to make changes in the array.
Example:

input:  arr = [1, 5, 4, 3, 2]

output: [1, 2, 3, 4, 5] # to clarify, this is
*/
import java.io.*;
import java.util.*;

class Solution {

  static int[] pancakeSort(int[] arr) {
    // your code goes here
    for(int i = arr.length - 1; i >= 1; i--){
      int maxIndex = findMaxIndexInPrefix(arr, i);
      flip(arr, maxIndex);
      flip(arr, i);
    }
    return arr;
  }

  static void flip(int[] arr, int k){
    int pivot = k / 2;
    for(int i = 0; i <= pivot; i++){
      int tmp = arr[i];
      arr[i] = arr[k - i];
      arr[k - i] = tmp;
    }
  }

  static int findMaxIndexInPrefix(int[] arr, int k){
    int ans = 0;
    for(int i = 0; i <= k; i++){
      if(arr[i] > arr[ans])
        ans = i;
    }
    return ans;
  }


  public static void main(String[] args) {

  }

}
