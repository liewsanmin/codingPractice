/**
Read N Characters Given Read4

The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function will only be called once for each test case.

algo :
consider edge cases 1st
    -- n > 4, and how to copy only n characters
    -- n < 4
    -- reach end of file or not

algo --
    *variables*
    buffer to be copied
    tmp[] to store characters read
    total for total chars stored currently
    currCount from the read4 api

    while currTotal < n and not reach end of file
        get currCount from read4 api(tmp[])
        set boolean variable for eof
        get actual currCount by comparing with n - total and currCount
        copy to buff(answer actually) and increment total

    once done, return the count
    reference pointer already updated

time -- O(n/4 + 1) - worst case
space -- O(n)
*/
public int read(char[] buf, int n){
    boolean eof = false;
    char[] tmp = new char[4];
    int total = 0;
    int currCount = 0;

    while(!eof && total < n){
        currCount = read4(tmp);

        eof = currCount < 4;
        currCount = Math.min(currCount, n - total);

        for(int i = 0; i < currCount; i++){
            buf[total++] = tmp[i];
        }
    }
    return total;
}
