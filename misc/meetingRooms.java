/**
Given an array of meeting time intervals consisting of start and end times
[[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
meetings. For example, Given [[0, 30],[5, 10],[15, 20]], return false.


algo : sort the intervals' start times
        go through array and make sure no overlap

        time - O(n log n)
        space - O(n log n)

*/

public boolean canAttendMeetings(Interval[] intervals){
    Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
    });

    for(int i = 0; i < intervals.length - 1; i++){
        if(intervals[i] > intervals[i+1])
            return false;
    }
    return true;
}
