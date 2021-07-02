/*
You have a function rand7() that generates a random integer from 1 to 7. Use it to write a
function rand5() that generates a random integer from 1 to 5.
rand7() returns each integer with equal probability. rand5() must also return each integer
with equal probability.

*/
public class Solution {
    public static int rand5() {
        int result = 7; // arbitrarily large
        while (result > 5) {
            result = rand7();
        }
    	return result;
	}
}
