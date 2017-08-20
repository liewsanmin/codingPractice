/*
The deletion distance of two strings is the minimum number of characters you
need to delete in the two strings in order to get the same string. For instance,
 the deletion distance between "heat" and "hit" is 3:

By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in
both cases.
We cannot get the same string from both strings by deleting 2 letters or fewer.
Given the strings str1 and str2, write an efficient function deletionDistance
that returns the deletion distance between them. Explain how your function works
, and analyze its time and space complexities.

Examples:

input:  str1 = "dog", str2 = "frog"
output: 3

input:  str1 = "some", str2 = "some"
output: 0

input:  str1 = "some", str2 = "thing"
output: 9

input:  str1 = "", str2 = ""
output: 0
Constraints:

[input] string str1
[input] string str2
[output] integer

Time Complexity: the time complexity stays the same, i.e. O(N⋅M), since we still
 run a nested loop with N⋅M iterations.

Space Complexity: O(min(N,M)), as we only need to hold two rows of the double
array.
*/

static int deletionDistance(String str1, String str2){
    if(str1.length()  < str2.length()){
      String tmpStr = str1;
      str1 = str2;
      str2 = tmpStr;
    }

    int str1Len = str1.length();
    int str2Len = str2.length();
    int[] prevMemo = new int[str2Len + 1];
    int[] currMemo = new int[str2Len + 1];


    for(int i = 0; i <= str1Len; i++){
      for(int j = 0; j <= str2Len; j++){
        if(i == 0)
          currMemo[j] = j;
        else if(j == 0)
          currMemo[j] = i;
        else if(str1.charAt(i-1) == str2.charAt(j-1))
          currMemo[j] = prevMemo[j - 1];
        else
          currMemo[j] = 1 + Math.min(prevMemo[j], currMemo[j-1]);
      }
      prevMemo = currMemo;
      currMemo = new int[str2Len + 1];
    }
    return prevMemo[str2Len];
  }
