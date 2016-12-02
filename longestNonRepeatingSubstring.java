/**
Given a string, find the longest substring without repeating characters.
For example, for string “abccdefgh”, the longest substring is “cdefgh”.

Brute force : collect each substring O(n^2) and check for duplicates O(n^2)
time -- O(n^4)
space - O(1)

optimize - space and time tradeoff

using a set, go through string and greedily update variable string 'longest'

things to consider : update when length of added is longer than previous 'longest'
                     when the longest string is at the last traversal character

variables : String longest
            HashSet<Character>
            start pointer
            end pointer
            len of input
            
time - O(n)
space - O(n)
*/

import java.util.*;
class Solution{
    public static void main(String[] args){
        String input = "";
        System.out.println(longestSubstring(input));
    }
    
    public static String longestSubstring(String input){
        if(input == null)
            return "";
        
        String longest = "";
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int inputLen = input.length();
        
        while(end < inputLen){
           
            char curr = input.charAt(end);
            if(!set.contains(curr)){
                set.add(curr);
                
                if((end - start +1) > longest.length()){
                    longest = input.substring(start, end + 1);
                    // System.out.println(longest);
                }
                    
            }
            
            else{
                while(start < end){
                    if(input.charAt(start) != curr){
                        set.remove(input.charAt(start));
                        start++;
                    }
                    else{
                        start++;
                        break;
                    }   
                }   
            }
            end++;
        }
        return longest;
    }
}
