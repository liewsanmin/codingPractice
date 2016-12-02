/**
Retun all possible products of number in a given array
Ex: [1 3 3 7] -> [1 3 7 9 21 63]

brute: for every product combinations put it into hashSet
time - O(n^2)
space - O(m) m = number of combinations

optimise:
        remove duplicates by adding into hashSet
        iterate through once
            for every iteration, start from that index and move forward
            and put the products in arrayList<Integer>
        time - O(m) m = number of combinations;
        space - O(m + n) n = number of non duplicates
        edge - null input
*/
import java.util.*;
public class Solution{
    public static void main(String[] args){
        int[] inputArr = null;
        ArrayList<Integer> ans = possibleProducts(inputArr);
        for(Integer curr : ans){
            System.out.print(curr + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> possibleProducts(int[] inputArr){
        if(inputArr == null)
            return null;
        HashSet<Integer> set = new HashSet<>();
        for(int curr : inputArr){
            set.add(curr);
        }
        int[] uniqueArr = new int[set.size()];
        int i = 0;
        for(Integer curr : set){
            uniqueArr[i++] = curr;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int uniqueArrLen = uniqueArr.length;
        for(i = 0; i < uniqueArrLen; i++){
            for(int j = i; j < uniqueArrLen; j++){
                int product = uniqueArr[i] * uniqueArr[j];
                ans.add(product);
            }
        }
        return ans;
    }
}
