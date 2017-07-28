/*
Sort a stack such that the smallest items are on the top
Can only use one extra stack

*/
import java.util.*;
public class sortStack{
    static Stack<Integer> sort(Stack<Integer> s){
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()){
            int temp = s.pop();
            while(!r.isEmpty() && r.peek() < temp){
                s.push(r.pop());
            }
            r.push(temp);
        }
        return r;
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(12);
        s.push(1);
        s.push(3);
        Stack<Integer> r = new Stack<>();
        r = sort(s);
        System.out.println(r.pop());
        System.out.println(r.pop());
        System.out.println(r.pop());
    }
}
