/**

You want to be able to access the largest element in a stack.
Use the built-in Stack class to implement a new class MaxStack with a function
 getMax() that returns the largest element in the stack. getMax() should not
  remove the item.

Your stacks will contain only integers.
*/
import java.util.*;
public class Solution {
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> maxs = new Stack<>();

    public static void push(int item){
        if(maxs.size() == 0 || item > maxs.peek()){
            maxs.push(item);
        }
        stack.push(item);
    }

    public static void pop(){
        if(stack.pop() == maxs.peek())
            maxs.pop();
    }

    public static int getMax(){
        return maxs.peek();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        System.out.println(getMax());
        pop();
        System.out.println(getMax());
        pop();
        System.out.println(getMax());
        pop();
        System.out.println(getMax());
        pop();
        System.out.println(getMax());

    }
}
