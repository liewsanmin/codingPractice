import java.io.*;
import java.util.*;
/*
Convert every letter to its ASCII value. Add 1 to the first letter, and then for
 every letter from the second one to the last one, add the value of the previous
  letter. Subtract 26 from every letter until it is in the range of lowercase
  letters a-z in ASCII. Convert the values back to letters.

For instance, to encrypt the word “crime”

Decrypted message:	c	r	i	m	e
Step 1:	99	114	105	109	101
Step 2:	100	214	319	428	529
Step 3:	100	110	111	116	113
Encrypted message:	d	n	o	t	q
The FBI needs an efficient method to decrypt messages. Write a function named
decrypt(word) that receives a string that consists of small latin letters only,
and returns the decrypted word.

Explain your solution and analyze its time and space complexities.

Examples:

input:  word = "dnotq"
output: "crime"

input:  word = "flgxswdliefy"
output: "encyclopedia"

time ans space - O(n)
*/
class Solution {

  static char[] decrypt(String word) {
      int secondStep = 1;
      String decryption = "";

      for(int i = 0; i < word.length(); i++){
        int newLetterAscii = (int)(word.charAt(i));
        newLetterAscii -= secondStep;

        while(newLetterAscii < 97)
          newLetterAscii += 26;

        decryption += (char) newLetterAscii;
        secondStep += newLetterAscii;
      }
    char[] ans = decryption.toCharArray();
    return ans;
  }

  public static void main(String[] args) {
      String word = "flgxswdliefy";
      char[] ans = decrypt(word);
      for(char curr : ans){
        System.out.print(curr + " ");
      }
  }
}
