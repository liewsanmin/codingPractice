/**
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.

algo:
    have a char array of 26 size
    have a map to store the charOccurence array, and list of valid anagrams
    have a list of list of strings
    for each string count the letters' occurences and store in charArray
    check if map contains that particular charArray
        yes : go to that charArray and add the anagram
        no : add to map

    for each charArray in map:
        add related list of strings to list<list<string>>

    return that list<list<string>>

time - O(m*n) m - number of strings, n - numbers of char in each string
space - O(m*n) m - number of charArray representing the strings, n - list of strings

edge - strs len less than 0 or invalid input
*/


import java.util.*;
public class Solution{

    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for(int i = 0; i < result.size(); i++){
                for(String curr : result.get(i)){
                    // System.out.print(curr + " ");
                }
                // System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String currString : strs){
            char[] charArr = new char[26];
            for(char currChar : currString.toCharArray()){
                charArr[currChar - 'a']++;
            }
            String stringArr = new String(charArr);
            System.out.print(stringArr + " ");
            if(map.containsKey(stringArr)){
                map.get(stringArr).add(currString);
            }
            else{
                ArrayList<String> currList = new ArrayList<>();
                currList.add(currString);
                map.put(stringArr, currList);
            }
        }

        result.addAll(map.values());
        return result;
    }
}
