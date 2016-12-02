/**
Quad Combination

Given an array of numbers arr and a number S, find 4 different numbers in arr
that sum up to S.

Write a function that gets arr and S and returns an array with 4 indices of
such numbers in arr, or null if no such combination exists.
Explain and code the most efficient solution possible, and analyze its runtime
and space complexity.

brute : go through all combination of sum and check if equal to quad comb
time -- O(n^4)

optimize : go through combination and save sum of 2 in a hashMap<Integer, arr[][]>
                    integer for the pairSum; arr[][]for the 2 indices
           now go through each element in map and find sum S - the pair = the pair
                once find that pair, make sure the indexes are all different
                with a helper method

time - O(n^2)
space - O(n^2)

edge - nums.length == null || target == null || nums.length < 4
*/
import java.util.*;
public class Solution{
    public static void main(String[] args){
        int[] arr = {1,2,3,1,2};
        int target = 20;
        ArrayList<ArrayList<Integer>> ans = fourSum(arr, target);
        if(ans == null)
            System.out.println("null");
        else{
            System.out.println(ans.get(0).get(0) + " " + ans.get(0).get(1));
            System.out.println(ans.get(1).get(0) + " " + ans.get(1).get(1));
        }
    }


    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length < 4)
            return null;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int arrLen = nums.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < arrLen; i++){
            for(int j = i + 1; j < arrLen; j++){
                int pairSum = nums[i] + nums[j];
                ArrayList<Integer> currList = new ArrayList<>();
                currList.add(pairSum);
                currList.add(i);
                currList.add(j);
                list.add(currList);
            }
        }

        for(int i = 0; i < list.size(); i++){
            // System.out.println(list.get(i).get(0) + " " + list.get(i).get(1) + " " + list.get(i).get(2));
            ArrayList<Integer> pairsA = new ArrayList<>();
            pairsA.add(list.get(i).get(1));
            pairsA.add(list.get(i).get(2));
            int pairSum = list.get(i).get(0);
            int complementPair = target - pairSum;

            // linear scan
            for(int j = 0; j < list.size(); j++){
                ArrayList<Integer> pairsB = new ArrayList<>();
                int currComplementPair = list.get(j).get(0);
                pairsB.add(list.get(j).get(1));
                pairsB.add(list.get(j).get(2));
                if(currComplementPair == complementPair && isFourUnique(pairsA, pairsB)){
                    ans.add(pairsA);
                    ans.add(pairsB);
                    return ans;
                }
            }
        }
        return null;
    }

    public static boolean isFourUnique(ArrayList<Integer> A, ArrayList<Integer> B){
        if(A.get(0) != B.get(0) &&
           A.get(0) != B.get(1) &&
           A.get(1) != B.get(0) &&
           A.get(1) != B.get(1))
               return true;
        return false;
    }
}
