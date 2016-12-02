/**
Time Planner
Implement a meeting planner that can schedule meetings between two persons at a
time.

Time is represented by Unix format (also called Epoch) - a positive integer
holding the seconds since January 1st, 1970 at midnight.

Planner input:

dur - Meeting duration in seconds (a positive integer).
timesA, timesB - Availability of each person, represented by an array of arrays.
Each sub-array is a time span holding the start (first element) and end
(second element) times.
You may assume that time spans are disjointed.
Planner output:

Array of two items - start and end times of the planned meeting, representing
the earliest opportunity for the two persons to meet for a dur length meeting.
If no possible meeting can be scheduled, return an empty array instead.

Design and implement an efficient solution and analyze its runtime and space
complexity.

brute - loop through both arrays and compare every single availabilities with the
        minimal duration
        time - O(mn)
        space - O(1)

optimize -  get max of start time in the beginning
            get min of end time in the beginning
            compare endTime - startTime >= duration
                yes - return answer
                no - increment the startTime of the smaller endTime at that point
            time - O(timeA + timeB) for a sorted array
                   O(A log A + B log B) for an unsorted array
            space - O(1)

edge case -- invalid input
*/
public class Solution{
    public static void main(String[] args){
        int[][] timeA = {{1,5},{6,9}};
        int[][] timeB = {{2,6},{7,10}};

        int[] ans = timePlanner(timeA, timeB, 3);
        System.out.println(ans[0] + " " + ans[1]);

    }

    public static int[] timePlanner(int[][] timeA, int[][] timeB, int duration){
        int[] ans = new int[2];
        int i = 0, j = 0;
        while(i < timeA.length && j < timeB.length){
            int startTime = Math.max(timeA[i][0], timeB[j][0]);
            int endTime = Math.min(timeA[i][1], timeB[j][1]);
            int currTime = endTime - startTime;
            if(currTime >= duration){
                ans[0] = startTime;
                ans[1] = startTime + duration;
                return ans;
            }
            else if(timeA[i][1] < timeB[j][1]){
                i++;
            }
            else
                j++;
        }
        ans[0] = 0;
        ans[1] = 0;
        return ans;
    }
}
