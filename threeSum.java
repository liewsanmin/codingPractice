/**
Determine if ANY 3 integers in an array sum to 0.

For example, for array [4, 3, -1, 2, -2, 10], the function should return true since 3 + (-1) + (-2) = 0. To make things simple, each number can be used at most once.

because x +(-x) = 0
 we treat the -x as 2sum approach (for a sorted array)
 
for each element{
    2 pointers, one at start and one at end
    if arr[start] + arr[end] = target, return the result
    if sum > target, end--
    else start++
    when they equal, because sorted don't need we know there are no more combinations
    done
}

time -- O(n log n) + O(n^2) = O(n^2)
space - O(1)
    
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        int[] arr = {10,2,1,-7};
        
        if(threeSum(arr))
            System.out.print("True");
        else
            System.out.print("False");
    }
    
    public static boolean threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(twoSum(nums, -nums[i]))
                return true;
        } 
        return false;
    }
    
    public static boolean twoSum(int[] nums, int target){
        int start = 0;
        int numsLen = nums.length;
        int end = nums.length - 1;

        while(start != end){
            if(nums[start] != -target || nums[end] != target){
                int currSum = nums[start] + nums[end];
                if(currSum == target){
                    return true;
                }
                if(currSum > target)
                    end--;
                else
                    start++;
            }
            
        }
        return false;
    }
}
