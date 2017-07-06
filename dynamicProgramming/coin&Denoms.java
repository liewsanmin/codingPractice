/*
Your quirky boss collects rare, old coins...
They found out you're a programmer and asked you to solve something they've been
 wondering for a long time.

Write a function that, given:

an amount of money
an array of coin denominations
computes the number of ways to make the amount of money with coins of the
available denominations.

Example: for amount=44 (44¢) and denominations=[1,2,3][1,2,3] (11¢, 22¢ and 33¢)
, your program would output 44—the number of ways to make 44¢ with those
denominations:

1¢, 1¢, 1¢, 1¢
1¢, 1¢, 2¢
1¢, 3¢
2¢, 2¢
*/
public class Solution {
    public static int changePossibilitiesBottomUp(int amount, int[] denominations){
        int[] waysOfDoingNCents = new int[amount + 1];
        waysOfDoingNCents[0] = 1;

        for(int coin : denominations){
            for(int higherAmount = coin; higherAmount <= amount; higherAmount++){
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }
        return waysOfDoingNCents[amount];
    }
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        int[] denoms = {1,2,3};
		System.out.println(changePossibilitiesBottomUp(4, denoms));
    }
}
