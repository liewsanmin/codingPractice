/**
Given a digit string, return all possible letter combinations that the number
could represent.

A mapping of digit to letters (just like on the telephone buttons) is given
below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in
any order you want.

algo : DFS approach (recursive)
1. map digits to letter in a hashMap
2. with helper function, find all combinations and put in StringBuilder

time - O(k^n) k - number of digits inputs
              n - number of character representation of that digits
space - O(k^n)

*/

import java.util.*;
public class Solution{
    public static void main(String[] args){
        List<String> ans = letterCombinations("23");
        for(String curr : ans)
            System.out.print(ans);
    }

    public static List<String> letterCombinations(String digits){
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        if(digits.equals(""))
            return ans;

        StringBuilder sb = new StringBuilder();
        int digitLen = digits.length();
        helper(digits, sb, 0, ans, digitLen, map);
        return ans;
    }

    public static void helper(String digits, StringBuilder sb,
                                      int index, List<String> ans, int digitLen,
                                      HashMap<Character, String> map){
        // base case
        if(index >= digitLen){
            ans.add(sb.toString());
            return;
        }
        
        char[] currCharArrOfDigit = map.get(digits.charAt(index)).toCharArray();
        int currCharLenOfDigit = currCharArrOfDigit.length;

        for(int i = 0; i < currCharLenOfDigit; i++){
            sb.append(currCharArrOfDigit[i]);
            helper(digits, sb, index + 1, ans, digitLen, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
