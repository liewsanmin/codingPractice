/*
Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the index of num in shiftArr. If num isn’t in shiftArr, return -1. Assume that the offset doesn’t equal to 0 (i.e. assume the array is shifted at least once) or to arr.length - 1 (i.e. assume the shifted array isn’t fully reversed).

Explain your solution and analyze its time and space complexities.

Example:

input:  shiftArr = [9, 12, 17, 2, 4, 5], num = 2 # shiftArr is the
                                                 # outcome of shifting
                                                 # [2, 4, 5, 9, 12, 17]
                                                 # three times to the left

output: 3 # since it’s the index of 2 in arr
*/

import java.io.*;
import java.util.*;

class Solution {

  static int shiftedArrSearch(int[] shiftArr, int num) {
      int pivot = findPivot(shiftArr);
      if(pivot == 0 || num < shiftArr[0])
        return binarySearch(shiftArr, pivot, shiftArr.length - 1, num);
      return binarySearch(shiftArr, 0, pivot - 1, num);
  }
  static int findPivot(int[] arr){
    int start = 0;
    int end = arr.length - 1;
    while(start <= end){
      int mid = start + (end - start) / 2;
      if(mid == 0 || arr[mid] < arr[mid - 1])
        return mid;
      if(arr[mid] > arr[0])
        start = mid + 1;
      else
        end = mid - 1;
    }
    return 0;
  }

  static int binarySearch(int[] arr, int start, int end, int num){
    while(start <= end){
      int mid = start + (end - start) / 2;
      if(arr[mid] < num)
        start = mid + 1;
      else if(arr[mid] == num)
        return mid;
      else
        end = mid - 1;
    }
    return -1;
  }


  public static void main(String[] args) {

  }

}
