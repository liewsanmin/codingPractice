/**
This is not a binary tree programming problem in the ordinary sense -- it's
more of a math/combinatorics recursion problem that happens to use binary trees.
 (Thanks to Jerry Cain for suggesting this problem.)
Suppose you are building an N node binary search tree with the values 1..N. How
many structurally different  binary search trees are there that store those
values? Write a recursive function that, given the number of distinct values,
computes the number of structurally unique binary search trees that store those
 values. For example, countTrees(4) should return 14, since there are 14
 structurally unique binary search trees that store 1, 2, 3, and 4. The base
 case is easy, and the recursion is short but dense. Your code should not
 construct any actual trees; it's just a counting problem.

 algo : for each root, go through left and right subtrees and count the
        unique trees
        base case : when the root is only 1 or less than 1, return 1
        sum of unique trees is just math of left * right




*/
class Node{
    int data;
    Node left, right;
    public Node(int item){
        data = item;
        left = right = null;
    }
}
public class Solution{
    public static void main(String[] args){
        System.out.println(countTrees(4));
    }

    public static void printPreOrder(Node node){

        if(node == null)
            return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static int countTrees(int numKeys){
        // base case
        if(numKeys <= 1)
            return 1;
        else{
            int left, right, sum = 0;

            // for each root
            for(int root = 1; root <= numKeys; root++){

                // recurse through left and right nodes
                left = countTrees(root - 1);
                right = countTrees(numKeys - root);

                sum += left*right;
            }
            return sum;
        }
    }
}
