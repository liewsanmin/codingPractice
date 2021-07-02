/*
Implement a regular expression function isMatch that supports the '.' and '*' symbols. The function receives two strings - text and pattern - and should return true if the text matches the pattern as a regular expression. For simplicity, assume that the actual symbols '.' and '*' do not appear in the text string and are used as special symbols only in the pattern string.

In case you aren’t familiar with regular expressions, the function determines if the text and pattern are the equal, where the '.' is treated as a single a character wildcard (see third example), and '*' is matched for a zero or more sequence of the previous letter (see fourth and fifth examples). For more information on regular expression matching, see the Regular Expression Wikipedia page.

Explain your algorithm, and analyze its time and space complexities.

Examples:

input:  text = "aa", pattern = "a"
output: false

input:  text = "aa", pattern = "aa"
output: true

input:  text = "abc", pattern = "a.c"
output: true

input:  text = "abbb", pattern = "ab*"
output: true

input:  text = "acd", pattern = "ab*c."
output: true
Constraints:

[time limit] 5000ms
[input] string text
[input] string pattern
[output] boolean

Time Complexity: in the worst case, the solution above runs in time exponential in the size of the pattern. Patterns that take the most time, are the ones with multiple '*' symbols, that may provoke an exponential number of recursion calls: For example, for the text “bbbbbbbb” and the pattern “.*.*.*.*a”, this function will open a new recursive call to itself for every single way to divide the text in four (the number of “.*”).

Space Complexity: the space required is also exponential because of the number of recursion calls filling up the stack. There are, in fact, algorithms that solve the matching problem in polynomial time and space. They are based on Nondeterministic Finite State Machines, which we didn’t provide here due to the fact that it requires more knowledge in theoretical computer science.
*/
import java.io.*;
import java.util.*;

class Solution {

  static boolean isMatch(String text, String pattern) {
    // your code goes here
    return isMatchHelper(text, pattern, 0, 0);
  }
  static boolean isMatchHelper(String text, String pattern, int textIndex, int patIndex){
    if(textIndex >= text.length()){
      if(patIndex >= pattern.length()){
        return true;
      }
      else if((patIndex+1 < pattern.length()) && (pattern.charAt(patIndex+1) == '*')){
      return isMatchHelper(text, pattern, textIndex, patIndex+2);
    }

      else
        return false;
    }else if ((patIndex+1 < pattern.length()) && (pattern.charAt(patIndex+1) == '*')){
      if(pattern.charAt(patIndex) == '.' || (text.charAt(textIndex) == pattern.charAt(patIndex))){
        return (isMatchHelper(text, pattern, textIndex, patIndex + 2) ||
                isMatchHelper(text, pattern, textIndex+1, patIndex));
      }
      else
        return isMatchHelper(text, pattern, textIndex, patIndex+2);
    } else if (pattern.charAt(patIndex) == '.' ||
               pattern.charAt(patIndex) == text.charAt(textIndex))
        return isMatchHelper(text, pattern, textIndex+1, patIndex+1);
      else
        return false;

  }

  public static void main(String[] args) {

  }

}
