/*
	a b c d	e
    pseudocode:
    	stack1, stack2

        enqueue(x)
        	stack1.push(x)

       	dequeue(x)
        	if stack 2 not empty
            	return stack2.pop
            else if stack 1 not empty
            	while(stack 1 not empty)
                	stack2.push(stack1.pop())
                return stack2.pop()
           else
           		return errmsg -> "queue is empty bro"
*/
import java.util.*;
public class Solution{
    public static void enqueue(Stack<Integer> inStack, int x){
        inStack.push(x);
    }

    public static int dequeue(Stack<Integer> inStack, Stack<Integer> outStack){
        if(outStack.size() > 0){
            return outStack.pop();
        }
        else if(inStack.size() > 0){
            while(inStack.size() != 0)
            	outStack.push(inStack.pop());
            return outStack.pop();
       }
       else
           throw new NoSuchElementException("Queue empty biatch!");
    }

    public static void main(String[] args){
        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

        enqueue(inStack, 1);
        enqueue(inStack, 2);
        enqueue(inStack, 3);
        System.out.println(dequeue(inStack, outStack));
        System.out.println(dequeue(inStack, outStack));
		enqueue(inStack, 4);
        System.out.println(dequeue(inStack, outStack));
        System.out.println(dequeue(inStack, outStack));
    }
}
