/*
scoreCounts
indices scores
values frequency of each score

37 1
41 1
53 1
65 1
89 1
91 1

topScores(arr, highest)
	scoreCount[]
    for each int in arr
    	scoreCount[curr]++

    j = 0
    for i = scoreCount.length - 1 to 0
    	if scoreCount[i] > 0
        	arr[j++] = scoreCount[i]
    return arr
 COUNTING SORT
 linear time and space
*/
public class Solution {
    public static int[] topScores(int[] arr, int highest) {
        int[] scoreCount = new int[highest];
        for(int curr : arr)
            scoreCount[curr]++;
        int i = 0;
        for(int j = scoreCount.length - 1; j >= 0; j--){
        	if(scoreCount[j] > 0){
                for(int k = 0; k < scoreCount[j]; k++)
                    arr[i++] = j;
            }

        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {37, 89, 41, 65, 91, 53};
        int highest = 100;
        int[] ans = topScores(arr, highest);
        for(int curr : ans)
            System.out.println(curr);
    }
}
