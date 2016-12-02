/**
Given a binary tree, compute its "maxDepth" -- the number of nodes along the longest path from the root node down to the farthest leaf node. The maxDepth of the empty tree is 0, the maxDepth of the tree on the first page is 3.

algo : have 2 ints
int left and recurse left subtree
int right and recurse right subtree

when reach null, return 0
after getting left and right values, return max of left and right , then  + 1

time - O(n)
space - O(n)

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
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.right = new Node(3);
        root.left.right.right = new Node(3);
        root.right = new Node(7);


        System.out.println(Integer.toString(maxDepth(root)));

    }

    public static int maxDepth(Node node){
        if(node == null)
            return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        return Math.max(left, right) + 1;
    }
}
