/**
Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while
maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
should be [1, 3, 12, 0, 0].

Be VERY CAREFUL with the indices and edge cases
*/

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length < 2)
           return;
        int p1 = 0;
        int p2 = 0;
        int arrLen = nums.length;
        while(p2 < arrLen){
            if(nums[p2] != 0){
                nums[p1++] = nums[p2];
            }
            p2++;
        }

        while(p1 < arrLen){
            nums[p1++] = 0;
        }
    }
}
