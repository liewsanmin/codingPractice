/*
Write a class TempTracker with these methods:

insert()—records a new temperature
getMax()—returns the highest temp we've seen so far
getMin()—returns the lowest temp we've seen so far
getMean()—returns the mean ↴ of all temps we've seen so far
getMode()—returns a mode ↴ of all temps we've seen so far
Optimize for space and time. Favor speeding up the getter functions (getMax(), getMin(), getMean(), and getMode()) over speeding up the insert() function.

getMean() should return a double, but the rest of the getter functions can return integers. Temperatures will all be inserted as integers. We'll record our temperatures in Fahrenheit, so we can assume they'll all be in the range 0..1100..110.

If there is more than one mode, return any of the modes.


initlize array with fixed size
getMax and getMin in O(1) by keeping track while inseting

getMean -> augment class to keep track of totalNum and totalSum
getMode -> array of occurances as well as data array to store
*/
public class tempTracker{
    int maxTemp= Integer.MIN_VALUE, minTemp = Integer.MAX_VALUE;
    double mean;
    int totalNum = 0;
    double totalSum = 0.0;
    int[] occurances = new int[111];
    int maxOccurances = 0;
    int mode;

    public tempTracker(){}

    public boolean insert(int temp){
        maxTemp = Math.max(temp);
        minTemp = Math.min(temp);

        totalNum++;
        totalSum += temp;
        mean = totalSum / totalNum;

        occurances[temp]++;
        if(occurances[temp] > maxOccurances){
            mode = temp;
            maxOccurances = occurances[temp];
        }
    }

    public int getMax(){
        return maxTemp;
    }

    public int getMin(){
        return minTemp;
    }

    public double getMean(){
        return mean;
    }

    public int getMode(){
        return mode;
    }

}
