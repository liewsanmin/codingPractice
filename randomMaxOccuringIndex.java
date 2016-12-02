/**
Given an array of integers, find the most occurring element of the array and return any one of its indexes randomly with equal probability.

Input: 
arr[] = [-1, 4, 9, 7, 7, 2, 7, 3, 0, 9, 6, 5, 7, 8, 9]

Output:  
Element with maximum frequency present at index 6
OR
Element with maximum frequency present at Index 3
OR
Element with maximum frequency present at index 4
OR
Element with maximum frequency present at index 12

All outputs above have equal probability.

algo 1:
1. find the max element, and their indexes
        go through array once and get max element O(n), O(1)
        go through array again and store indexes O(n), O(n)
        get a random number from 0 to number of stored indexes O(1)
        get a random index from the random number -- O(1)
        
        time - O(n); space - O(n)
        
algo 2:

    instead of storing indexes, get a random number from 0 to array length
    go through array from 0 to array length and see if equal to max element
        if not repeat until equal max, and return that index
    
    time - O(n)
    space - O(1)
    
algo 3: 
    use voting algo to find max
    go through again and count max occurence and store to maxLen
    get random number from 1 to maxLen
    go through array again and return rand'th occurence of the max element
    
    time - O(n)
    space - O(1)
    
algo 4: from geeks for geeks
    The idea is to iterate through the array once and find out the maximum occurring element and its frequency n. Then we generate a random number r between 1 and n and finally return the r’th occurrence of maximum occurring element in the array.

    go through array twice
        one to store the numbers and their respective freq
        one is to find the max and respective freq
    
    get random number from 1 to freq
    go through array and find the rand'th value of the number
    
    time - O(n)
    space - O(n)
    
    make sure to discuss time and space tradeoffs
    
edge - null input

*/

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Solution{
    public static void main(String[] args){
        int arr[] = {2, 8, 8, 8, 8, 4, 1, 7};        
        System.out.print(maxIndex(arr));
    }
    
    public static int maxIndex(int[] arr){
        if(arr == null)
            return -1; // to indicate error
        int idx = -1;
        // map to store number and freq
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int curr : arr){
            if(map.containsKey(curr))
                map.put(curr, map.get(curr) + 1);
            else
                map.put(curr, 1);
        }
        
        int maxVal = arr[0];
        int maxFreq = map.get(arr[0]);
        for(int curr : arr){
            int i = map.get(curr);
            if(i > maxFreq){
                maxVal = curr;
                maxFreq = i;
            }
        }
        
        int random = ThreadLocalRandom.current().nextInt(1, maxFreq + 1);
        int randCnt = 0;
        for(int i = 0; i < arr.length; i++){
            int curr = arr[i];
            if(curr == maxVal)
                randCnt++;
            if(randCnt >= random){
                idx = i;
                break;
            }
        }
        return idx;
    }
}
