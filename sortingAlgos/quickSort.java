/**
Quicksort
Select a pivot, normally the middle one
From both ends, swap elements and make left elements < pivot and all right > pivot
Recursively sort left part and right part

time - O(n log(n))
space - O(n log(n))
*/
import java.util.*;
public class Solution {
    public static void main(String[] args) {
		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
		System.out.println(Arrays.toString(x));

		int low = 0;
		int high = x.length - 1;

		quickSort(x, low, high);
		System.out.println(Arrays.toString(x));
	}

	public static void quickSort(int[] arr, int low, int high) {
        if(arr == null || arr.length == 0)
            return;

        if(low >= high)
            return;

        int i = low;
        int j = high;
        int mid = (low + high) / 2;
        int pivot = arr[mid];

        while(i <= j){
            while(arr[i] < pivot)
                i++;
            while(arr[j] > pivot)
                j--;
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if(low < j)
            quickSort(arr, low, j); // left part
        if(high > i)
            quickSort(arr, i, high); // right part
    }
}
