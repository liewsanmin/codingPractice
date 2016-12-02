/**
Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid
but "(]" and "([)]" are not.

algo :
    iterate through once
    have a stack
    when see "(" "[" "{" add to stack
    when see ")" "]"  "}" pop one from stack and check if balanced or not
        if not return false
    when done with loop, check if stack is empty
    if stack empty return false

edge : s is null || only closing parenthesis

time - O(n)
space - O(n)
*/
import java.util.*;
public class Solution{
    public static void main(String[] args){
        String input = null;
        if(validParenthesis(input))
            System.out.println("True");
        else
            System.out.println("False");
    }

    public static boolean validParenthesis(String input){
        if(input == null)
            return false;

        Stack<Character> stack = new Stack<>();
        for(char curr : input.toCharArray()){
            if(curr == '(' ||
               curr == '[' ||
               curr == '{')
                   stack.add(curr);
            else if(curr == ')' ||
                    curr == ']' ||
                    curr == '}'){
                        if(stack.isEmpty()) // meaning we don't have opening at all
                            return false;
                        char popped = stack.pop();
                        if (popped == '(' && curr != ')' ||
                            popped == '[' && curr != ']' ||
                            popped == '{' && curr != '}')
                                return false;
                    }
        }
        if(!stack.isEmpty())
            return false;

        return true;
    }
}
