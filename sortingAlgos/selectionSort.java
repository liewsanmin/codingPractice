/**
Selection Sort

algo :
    linearly scan and find smallest
    put smallest at front
    repeat to find second smallest and put to next to front
    repeat until end

time - O(n^2)
space - O(1)
edge - null array
*/

class Solution{
    public static void main(String[] args){
        int[] arr = {7,1,4,8};
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr){
        if(arr == null)
            return;
        for(int i = 0; i < arr.length - 1; i++){
            int swapIdx = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] <  arr[swapIdx])
                    swapIdx = j;
            }
            int temp = arr[swapIdx];
            arr[swapIdx] = arr[i];
            arr[i] = temp;
        }

        for(int curr : arr){
            System.out.print(Integer.toString(curr) + " ");
        }
    }
}
