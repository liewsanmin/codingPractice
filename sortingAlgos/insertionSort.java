/**
2 parts, sorted part and unsorted part
O(n^2) -- worst case
O(n) -- best case
*/

class Solution{
    public static void main(String[] args){
        System.out.println("Hello");
        int[] arr = {1,3,4,1,-2,8,-3};
        int[] sortedArr = insertionSort(arr);
        for(int curr : sortedArr){
            System.out.print(Integer.toString(curr) + " ");
        }
    }

    private static int[] insertionSort(int[] arr){
        int lastIdx = arr.length - 1;
        for(int i = 1; i <= lastIdx; i++){ // traverse through unsorted part
            int element = arr[i];
            int j = i;
            while(j > 0 && arr[j-1] > element){ // traverse through sorted part
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = element;
        }
        return arr;
    }
}
