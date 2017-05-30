/**
Given an array, data, of data points, write a function findBusiestPeriod that returns the time at which the mall reached its busiest moment last year. The return value is the timestamp, e.g. 1480640292. Note that if there is more than one period with the same visitor peak, return the earliest one.

Assume that the array data is sorted in an ascending order by the timestamp. Explain your solution and analyze its time and space complexities.

Example:

input:  data = [ [1487799425, 14, 1],
                 [1487799425, 4,  0],
                 [1487799425, 2,  0],
                 [1487800378, 10, 1],
                 [1487801478, 18, 0],
                 [1487801478, 18, 1],
                 [1487901013, 1,  0],
                 [1487901211, 7,  1],
                 [1487901211, 7,  0] ]

output: 1487800378 # since the increase in the number of people
                   # in the mall is the highest at that point
Constraints:

[time limit] 5000ms

[input] array.array.integer data

1 ≤ data.length ≤ 100
[output] integer

time - O(n)
space - O(1)
*/
class findBusiestPeriod{
    static int findBusiestPeriod(int[][] data){
        int maxCount = 0, count = 0, maxPeriod = 0, n = data.length;
        for(int i = 0; i < n; i++){
            if(data[i][2] == 1)
                count += data[i][1];
            else if(data[i][2] == 0)
                count -= data[i][1];

            // check for other data points with the same timestamp
            if (i < n-1 && data[i][0] == data[i+1][0])
                continue;

            if(count > maxCount){
                maxCount = count;
                maxPeriod = data[i][0];
            }
        }
        return maxPeriod;
    }
    public static void main(String[] args){
        int[][] data = { {1487799425, 14, 1},
                         {1487799425, 4,  0},
                         {1487799425, 2,  0},
                         {1487800378, 10, 1},
                         {1487801478, 18, 0},
                         {1487801478, 18, 1},
                         {1487901013, 1,  0},
                         {1487901211, 7,  1},
                         {1487901211, 7,  0} };
        System.out.println(findBusiestPeriod(data));
    }
}
