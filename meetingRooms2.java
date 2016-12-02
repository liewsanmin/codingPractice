/**
Meeting Rooms II
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.


The problem can be also transformed as max number of overlaps.
algo :
        startime arr
        endtime arr
        sort both
        meetingRooms int
        activeRooms int
        i for startTimes
        j for endTimes
        startTime < endTime > i++, activeMeetings++; max of numMeetingRooms
            else j++, activeMeetings--
time - O(n log n)
space - O(m+n) m - start times, n = end times
edge - invalid input, inputlen = 0
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() {
            start = 0; end = 0;
        }
 *     Interval(int s, int e) {
            start = s;
            end = e;
        }
 * }
 */
public class Solution{
    public int minMeetingRooms(Interval[] intervals){
        if(intervals == null || intervals.length == 0)
            return 0;
        int intervalsLen = intervals.length;
        int[] startTimes = new int[intervalsLen];
        int[] endTimes = new int[intervalsLen];

        for(int i = 0; i < intervalsLen; i++){
            Interval curr = new Interval();
            startTimes[i] = curr.start;
            endTimes[i] = curr.end;
        }

        // sort both arrays
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int activeMeetings = 0;
        int meetingRooms = 0;

        int i = 1;
        int j = 0;
        while(i < intervalsLen && j < intervalsLen){
            if(startTime[i] < endTimes[j]){
                activeMeetings++;
                meetingRooms = Math.max(meetingRooms, activeMeetings);
                i++;
            }
            else{
                activeMeetings--;
                j++;
            }
        }
        return meetingRooms;
    }
}
