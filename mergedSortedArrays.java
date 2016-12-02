/**
We have our lists of orders sorted numerically already, in arrays. Write a
function to merge our arrays of orders into one sorted array.

For example:

  int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

System.out.println(mergeArrays(myArray, alicesArray));
// prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]

Greedy algo :
    2 pointers; p1 to arr1; p2 to array2
    whichever is smaller adds to new array and increment to added ori array
    whichever reaches the end, just continue adding the other until end

    time - O(n+m) n = p1 size; m = p2 size;
    space - O(n+m) to store new array

    edge - when either reaches end
            invalid inputs
*/

public class Solution{
    public static void main(String[] args){
        int[] arr1 = {1,5,5,12};
        int[] arr2 = {3,4,4};
        int[] ans = mergedSortedArray(arr1, arr2);
        for(int curr : ans){
            System.out.print(curr + " ");
        }
    }

    public static int[] mergedSortedArray(int[] arr1, int[] arr2){
        int p1 = 0;
        int p2 = 0;
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;
        int[] mergedArr = new int[arr1Len + arr2Len];
        int currIdx = 0;

        while(p1 < arr1Len && p2 < arr2Len){
            if(arr1[p1] < arr2[p2])
                mergedArr[currIdx++] = arr1[p1++];
            else
                mergedArr[currIdx++] = arr2[p2++];
        }

        while(p2 < arr2Len)
            mergedArr[currIdx++] = arr2[p2++];

        while(p1 < arr1Len)
            mergedArr[currIdx++] = arr1[p1++];

        return mergedArr;
    }
}
