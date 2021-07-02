/**
Your company built an in-house calendar tool called HiCal. You want to add a
feature to see the times in a day when everyone is available.
To do this, you’ll need to know when any team is having a meeting. In HiCal, a
meeting is stored as an object of a Meeting class with integer variables
startTime and endTime. These integers represent the number of 30-minute blocks
past 9:00am.


public class Meeting {

  int startTime;
  int endTime;

  public Meeting(int startTime, int endTime) {
      // number of 30 min blocks past 9:00 am
      this.startTime = startTime;
      this.endTime   = endTime;
  }

  public String toString() {
      return String.format("(%d, %d)", startTime, endTime);
  }
}
For example, given:

  [ Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10) ]

your function would return:

  [ Meeting(0, 1), Meeting(3, 8), Meeting(9, 12) ]

  time - O(n lg n)
  space - O(n)
*/

import java.util.*;
public class mergeRanges{
    public static ArrayList<Meeting> mergeRanges(ArrayList<Meeting> arr){
        // sort the list
        quickSort(arr, 0, arr.size() - 1);


        // follow formal algo
        int i = 0;
        while(i < arr.size() -1){
            if(arr.get(i).endTime >= arr.get(i+1).startTime){
                arr.get(i).endTime = Math.max(arr.get(i).endTime, arr.get(i+1).endTime);
                arr.remove(i+1);
            }
            else
                i++;
        }
        return arr;
    }

    public static void quickSort(ArrayList<Meeting> arr, int low, int high){
        if(arr == null || arr.size() == 0)
            return;

        if(low >= high)
            return;

        int i = low;
        int j = high;
        int mid = (low + high) / 2;
        int pivot = arr.get(mid).startTime;

        while(i <= j){
            while(arr.get(i).startTime < pivot)
                i++;
            while(arr.get(j).startTime > pivot)
                j--;
            if(i <= j){
                Meeting temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                i++;
                j--;
            }
        }
        if(low < j)
            quickSort(arr, low, j);
        if(high > i)
            quickSort(arr, i, high);
    }

    public static void main(String args[]){

        ArrayList<Meeting> m = new ArrayList<>();
        m.add(new Meeting(1,10));
        m.add(new Meeting(2,6));
        m.add(new Meeting(3,5));
        m.add(new Meeting(7,9));

        ArrayList<Meeting> ans = mergeRanges(m);
        for(Meeting curr : ans){
            System.out.print(curr.toString() + " ");
        }
        System.out.println();
    }
}

/**
    more scalable version
    - using comparator
    - going backwards
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public List<Meeting> mergeRanges(List<Meeting> meetings) {
    // sort by start times
    List<Meetings> sortedMeetings = new ArrayList<Meeting>(meetings);
    Collections.sort(sortedMeetings, new Comparator<Meeting>() {
        public int compare(Meeting m1, Meeting m2){
            return m1.startTime - m2.starTime;
        }
    });

    //initialize mergedMeetings with the earliest meeting
    List<Meeting> mergedMeetings = new ArrayList<Meeting>();
    mergedMeetings.add(sortedMeetings.get(0));

    for(Meeting currentMeeting : sortedMeetings){
        Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

        //if the current and last meetings overlap use the latest end time
        if(currentMeeting.startTime <= lastMergedMeeting.endTime)
            lastMergedMeeting.endTime = Math.max(lastMergedMeeting.endTime, currentMeeting.endTime);
        else
            mergedMeetings.add(currentMeeting);
    }
    return mergedMeetings;
}
