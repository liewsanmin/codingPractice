import java.io.*;
import java.util.*;

public class Solution {
    // I will attempt 3 methods in this prompt
    // common mistakes  - array index error
    //

    // method 1 - store string as byte array
    //          - store another byte array which reverse via a for loop
    //          - use the charset mapping to return a string from the reversed byte array
    // only beats around 43% of submissions
    public String reverseString(String s) {
        byte stringAsByte[] = s.getBytes();
        byte result[] = new byte[stringAsByte.length];

        for (int i = 0; i < stringAsByte.length; i++){
            result[i] = stringAsByte[stringAsByte.length - i -1];
        }

        return new String(result);
    }

    /**
     * Method 2 - store them in char array using String()
     *          - swap them in a for loop, 1st and last
     * this method beats 89.94% of submissions, faster than method 1
     */
     public String reverseString(String s){
         char[] inputChar = s.toCharArray();

         int i = 0;
         int j = s.length() - 1;

         while (i < j){
                char temp = inputChar[i];
                inputChar[i] = inputChar[j];
                inputChar[j] = temp;
                i++;
                j--;
         }
        return new String(inputChar);
     }

     /**
      * Method 3 - unconventional way of using ^ 3 times, without temp variable
      *          - with byte
      */
      public String reverseString(String s){
          byte[] stringAsByte = s.getBytes();

          int j = s.length() - 1;
          for (int i = 0; i < j; i++){
              stringAsByte[i] = (byte) (stringAsByte[i] ^ stringAsByte[j]);
              stringAsByte[j] = (byte) (stringAsByte[i] ^ stringAsByte[j]);
              stringAsByte[i] = (byte) (stringAsByte[i] ^ stringAsByte[j]);
              j--;
          }
          return new String(stringAsByte);
      }

}
