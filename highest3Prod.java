/**
Given an array of integers, find the highest product you can get from three of the integers.
The input arrayOfInts will always have at least three integers.
    time - O(n)
    space - O(1)

 */
import java.util.*;
public class highest3Prod{
    public static int highest3Prod(int[] arr){
        int currHigh3 = Integer.MIN_VALUE, currHigh2, currLow2, currLow, currHigh;

        currHigh2 = currLow2 = arr[0] * arr[1];
        currHigh = Math.max(arr[0], arr[1]);
        currLow = Math.min(arr[0], arr[1]);

        for(int i  = 2; i < arr.length; i++){
            // update currHigh3
            currHigh3 = Math.max(currHigh3, Math.max(arr[i] * currHigh2, arr[i] * currLow2));

            // update currHigh2 & currLow2
            currHigh2 = Math.max(currHigh2, Math.max(arr[i] * currHigh, arr[i] * currLow));
            currLow2 = Math.min(currLow2, Math.min(arr[i] * currHigh, arr[i] * currLow));

            // update currLow & currHigh
            currHigh = Math.max(arr[i], currHigh);
            currLow = Math.min(arr[i], currLow);
        }
        return currHigh3;
    }
    public static void main(String args[]){
        int[] arr = {-10, -10, 1, 3, 2};
        System.out.println(highest3Prod(arr));
    }
}
