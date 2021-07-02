/*
I suspect the online poker game I'm playing shuffles cards by doing a single " riffle ↴ ."

To prove this, let's write a function to tell us if a full deck of cards shuffledDeck is
a single riffle of two other halves half1 and half2.

We'll represent a stack of cards as an array of integers in the range 1..521..52
(since there are 5252 distinct cards in a deck).
*/
public class Solution {
    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck){
        if(shuffledDeck.length <= 0)
            return false;
    	int shuffledDeckIndex = 0, half1Index = 0, half2Index = 0;
        while(shuffledDeckIndex != shuffledDeck.length){
        	if ((half1Index < half1.length)
            && (half1[half1Index] == shuffledDeck[shuffledDeckIndex])) {
        		half1Index++;

            // if we still have cards in half2
            // and the "top" card in half2 is the same
            // as the top card in shuffledDeck
            } else if ((half2Index < half2.length)
                    && (half2[half2Index] == shuffledDeck[shuffledDeckIndex])) {
                half2Index++;

            // if the top card in shuffledDeck doesn't match the top
            // card in half1 or half2, this isn't a single riffle.
            } else {
                return false;
            }

            // the current card in shuffledDeck has now been "accounted for"
            // so move on to the next one
            shuffledDeckIndex++;
        }
        return true;
    }
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        int[] half1 = {1,2,3};
        int[] half2 = {4,5,6};
        int[] shuffledDeck = {1,4,2,5,3,6,7};
        System.out.println(isSingleRiffle(half1, half2, shuffledDeck));
    }
}
