/**
2sum – given a sorted array, find 2 numbers that sum up to S.

2 pointers, one at start and one at end
if arr[start] + arr[end] = target, return the result
if sum > target, end--
else start++
when they equal, because sorted don't need we know there are no more combinations
done
*/

class Solution{
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        int sum = 11;
        
        twoSum(arr, sum);
    }
    
    public static void twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int start = 0;
        int numsLen = nums.length;
        int end = nums.length - 1;

        while(start != end){
            int currSum = nums[start] + nums[end];
            if(currSum == target){
                result[0] = start;
                result[1] = end;
                break;
            }
            if(currSum > target)
                end--;
            else
                start++;
        }
        System.out.print(result[0] + " " + result[1]);
    }
}
