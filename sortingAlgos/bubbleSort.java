/**
Bubble Sort

for ascending order -- bubble up the max element to the end of array
at each iteration from 0th to n - 1
    bubble the element up

time - O(n^2)
space - O(1)


*/
class Solution{
    public static void main(String[] args){
        int[] arr = {1,2,3,13,3,23};
        arr = bubbleSort(arr);
        for(int curr : arr){
            System.out.print(Integer.toString(curr) + " ");
        }
    }

    public static int[] bubbleSort(int[] arr){
        int lastIdx = arr.length - 1;

        boolean sorted = false;
        int i = 0;
        while(!sorted && i < lastIdx){
            sorted = true;
            for(int j = 0; j < lastIdx - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;
                }
            }
            i++;
        }
        return arr;
    }

}
