/*
a stack that also has a min function
*/

import java.util.*;
public class stackMin extends Stack<Integer>{
    Stack<Integer> s2;
    public stackMin(){
        s2 = new Stack<Integer>();
    }

    public void push(int value){
        if(value <= min())
            s2.push(value);
        super.push(value);
    }

    public Integer pop(){
        int value = super.pop();
        if(value == min())
            s2.pop();
        return value;
    }

    public int min(){
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
        } else
            return s2.peek();
    }
}
