/**
Find next greater number with same set of digits
Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.

Examples:
For simplicity of implementation, we have considered input number as a string.

Input:  n = "218765"
Output: "251678"

Input:  n = "1234"
Output: "1243"

Input: n = "4321"
Output: "Not Possible"

Input: n = "534976"
Output: "536479"
*/

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int i = 0; i < testCase; i++){
		  int ans = nextNumber(sc.nextInt());
		    if(ans == -1)
		        System.out.println("not possible");
		    else
		        System.out.println(ans);
		}
	}
	private static int nextNumber(int num){
	    String number = Integer.toString(num);
	    char[] arr = number.toCharArray();
	    int lastIdx = number.length() - 1;
	    int currIdx = lastIdx - 1;
	    while(currIdx >= 0){
	        if(arr[currIdx + 1] > arr[currIdx])
	            break;
	        else 
	            currIdx--;
	    }
	    if(currIdx < 0)
	        return -1;
	    
	    // search for next smallest
	    int smallestGreater = Character.getNumericValue(arr[currIdx + 1]);
	   int swapIdx = 0;
	    for(int i = currIdx + 1; i <= lastIdx; i++){
	        if(Character.getNumericValue(arr[i]) > Character.getNumericValue(arr[currIdx])){
	            smallestGreater = Math.min(smallestGreater, Character.getNumericValue(arr[i]));
	            swapIdx = i;
	        }
	    }

	   // // swap here
	    char temp = arr[swapIdx];
	    arr[swapIdx] = arr[currIdx];
	    arr[currIdx] = temp;
	    
	    // sort in O(n) order
	    int start = currIdx + 1;
	    int midToSort = start + (lastIdx - start) / 2;
	    for(int i = start, j = lastIdx; i <= midToSort && j >= 0; i++, j--){
	        temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	   return Integer.parseInt(new String(arr));
	}
}
