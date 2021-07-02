/*
ctci pg 342


*/

// memoization
int countWays(int n){
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return countWays(n, memo);
}

int countWays(int n, int[] memo){
    if(n < 0) // when reach out of bounds
        return 0;
    else if(n == 0) // base case
        return 1;
    else if(memo[n] > -1){ // when already have answer
        return memo[n];
    }
    else{ // when no answer yet
        memo[n] = countWays(n-1, memo) + countWays(n-2, memo) +
                  countWays(n-3,memo);
    }
}
