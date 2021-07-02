/*
We have an array of integers, where:

The integers are in the range 1..n1..n
The array has a length of n+1n+1
It follows that our array has at least one integer which appears at least twice.
 But it may have several duplicates, and each duplicate may appear more than
 twice.

Write a function which finds an integer that appears more than once in our
array. (If there are multiple duplicates, you only need to find one of them.)

O(1) space and O(n\lg{n})O(nlgn) time.
*/

public static int findRepeat(int[] theArray){
    int floor = 1;
    int ceiling = theArray.length - 1;

    while(floor < ceiling){
        int midpoint = floor + ((ceiling - floor) / 2);
        int lowerRangeFloor = floor;
        int lowerRangeCeiling = midpoint;
        int upperRangeFloor = midpoint + 1;
        int upperRangeCeiling = ceiling;

        int itemsInlowerRange = 0;
        for(int item : theArray){
            if(item >= lowerRangeFloor && item <= lowerRangeCeiling){
                itemsInLowerRange += 1;
            }
        }
        int distinctPossibleIntegersInLowerRange = lowerRangeCeiling - lowerRangeFloor + 1;

        if(itemsInLowerRange > distinctPossibleIntegersInLowerRange){
            floor = lowerRangeFloor;
            ceiling = lowerRangerCeiling;
        } else {
            floor = upperRangeFloor;
            ceiling = upperRangeCeiling;
        }
    }
    return floor;
}
