/*
Write an efficient function that checks whether any permutation ↴ of an input
string is a palindrome ↴ .
*/
import java.util.*;
public class Solution {
    public static boolean permutationPalindrome(String in) {
        char[] arr = in.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(char curr : arr){
            if(set.contains(curr))
                set.remove(curr);
            else
                set.add(curr);
        }
        return set.size() <= 1;
    }
    public static void main(String[] args) {
        String testInput = "livci";
        System.out.println(permutationPalindrome(testInput));
    }
}
