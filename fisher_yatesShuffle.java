/*
Write a function for doing an in-place ↴ shuffle of an array.
The shuffle must be "uniform," meaning each item in the original array must
have the same probability of ending up in each spot in the final array.

Assume that you have a function getRandom(floor, ceiling) for getting a random
 integer that is >= floor and <= ceiling.
*/

import java.util.Random;
public class Solution {
    private static Random rand = new Random();
    private static int getRandom(int floor, int ceiling){
    	return rand.nextInt((ceiling - floor) + 1) + floor;
    }
    public static void shuffle(int[] theArray){
        // if it's 1 or 0 items, just return
        if(theArray.length <= 1){
        	return;
        }

        // walk through from beginning to end
        for(int indexWeAreChoosingFor = 0;
            indexWeAreChoosingFor < theArray.length - 1; indexWeAreChoosingFor++){

        	int randomChoiceIndex = getRandom(indexWeAreChoosingFor, theArray.length - 1);
            if(randomChoiceIndex != indexWeAreChoosingFor){
            	int valueAtIndexWeChoseFor = theArray[indexWeAreChoosingFor];
                theArray[indexWeAreChoosingFor] = theArray[randomChoiceIndex];
                theArray[randomChoiceIndex] = valueAtIndexWeChoseFor;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        shuffle(arr);
        for(int curr : arr){
        	System.out.print(curr + " ");
        }
    }
}
