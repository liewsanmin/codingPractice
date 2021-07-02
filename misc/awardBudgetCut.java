/**
Award Budget Cuts

The awards committee had planned to give n research grants this year, out of a its total yearly budget.
However, the budget was reduced to b dollars. The committee members has decided to affect the minimal number of highest grants, by applying a maximum cap c on all grants: every grant that was planned to be higher than c will now be c dollars.
Help the committee to choose the right value of c that would make the total sum of grants equal to the new budget.

Given an array of grants g and a new budget b, explain and code an efficient method to find the cap c. Assume that each grant is unique.
Analyze the time and space complexity of your solution.

algo
math : 
1. g[r-1] ≤ c ≤ g[r]
2. capped sum is: capped(cap) = sum(g[0], g[1], ..., g[r-1]) + (n - r)∙cap, for such r.
3. Clearly capped(c) = b, and by our definition of r: capped(g[r-1]) ≤ b ≤ capped(g[r]). Once we find r, we can calculate c easily from the capped sum equation.
4. Linear scan for r is possible but not optimal. A better approach to find r is by a something similar to binary search. This can work because the array is sorted. We can apply the inequality capped(g[r-1]) ≤ b ≤ capped(g[r]) as our stopping condition for the search. For each middle index on the search we compute capped(g[m]) and capped(g[m-1]) and direct the search accordingly.

runtime - O(n log)
space - O(n)

or we could search the array linearly so that space -- O(1)

*/
import java.util.*;
class Solution
{
    public static void main(String[] args)
    {
        double grants[] = {7,5,2,3,1};
        double b = 13;
        
        System.out.println(Double.toString(findGrantsCap(grants, b)));
    }
    
    public static double findGrantsCap(double[] g, double b)
    {
        if(g == null || g.length == 0)
            return 0;
        int n = g.length;
        double[] partialSum = new double[n];
        Arrays.sort(g);
        double tempSum = 0;

        for(int i = 0; i < n; i++)
        {
            tempSum += g[i];
            partialSum[i] = tempSum;
        }
        if(partialSum[n - 1] <= b)
            return g[n - 1];
        
        int start = 0;
        int end = n - 1;
        int r = 4;
        
        for(double curr : partialSum){
            // System.out.print(Integer.toString(curr) + " ");
        }
        while(end > start){
            r = (start + (end - start) / 2);
            if(r > 0){
                if(cappedSum(r, partialSum, g, n) > b){
                    if(cappedSum(r - 1, partialSum, g, n) < b)
                        break;
                    else
                        end = r -1;
                }
                else
                    start = r + 1;
            }
        }
        // System.out.print(Double.toString(cappedSum(r, partialSum, g, n)) + " ");
        
        double c = 0;
        c = (b - partialSum[r-1]) / (n-r);
        return c;
    }
    
    public static double cappedSum(int i, double[] partialSum, double[] g, int n){
        return partialSum[i] + g[i]*(n-i);
    }
}

