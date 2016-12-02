/**
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.


since lowercase, we can use only char array of 26 letters

algo 1:
convert both strings to charArray
sort both strings
compare both strings together and return false when either is not equal
return true when reach end of list

runtime - O(n log n) 2 sorting array time
space - O(1)


algo 2: 
have a direct access table of char array with 26 letters
go through first string and increment its respective position in the char array
go through second string and decrement its respective position in the char array
    when counter reaches less than 0, return false

when list ends, return true

runtime - O(2n) = O(n) - this is minimum case

space - O(n) n is 26 alphabets

edge cases when either string is null or the length don't match
*/


class Solution{
    public static void main(String[] args){
        String s1 = "cats";
        String s2 = "tacs";
        if(validAnagram(s1, s2))
            System.out.println("True");
        else
            System.out.println("False");
    }
    
    public static boolean validAnagram(String s1, String s2){
        if(s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        
        int[] arr = new int[26];
        
        for(char curr : s1.toCharArray()){
            arr[curr - 'a']++;
        }
        
        for(char curr : s1.toCharArray()){
            arr[curr - 'a']--;
            if(arr[curr - 'a'] < 0)
                return false;
        }
        return true;
    }
}

