/**
Practicing binarySearch
*/

class Solution{
    public static void main(String[] args){
        int[] arr = {0,1,2,4,6,7};
        if(binarySearch(arr, 8))
            System.out.println("Exist");
        else
            System.out.println("Not exist");
    }
    
    private static boolean binarySearch(int[] arr, int target){
        if(arr == null)
            return null;
        int start = 0;
        int last = arr.length - 1;
        
        while(start <= last){
            int mid = (start + last) / 2;
            if(arr[mid] == target)
                return true;
            else if(target > arr[mid])
                start = mid + 1;
            else
                last = mid - 1;
        }
        return false;
    }
}
