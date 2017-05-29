/**
time - O(n)
iterativ bottom up approach

*/
import java.util.*;
class fibo{
    public static int fibo(int x){
        if(x == 0 || x == 1)
            return x;
        int prevPrev = 0;
        int prev = 1;
        int current = 0;

        int i = 1;
        while(i < x){
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
            i++;
        }
        return current;
    }

    public static void main(String[] args){
        System.out.println(fibo(6));
    }
}
