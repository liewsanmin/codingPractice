/**
Given a binary tree, print out all of its root-to-leaf paths, one per line.


have a recursive helper with array, and pathLen to keep track recursively
time -- O(n) -- n = number of nodes
space -- O(n)
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
        root.right = new Node(7);
        root.right.left = new Node(1);
        root.right.right = new Node(3);

        printPaths(root);
    }

    public static void printPaths(Node root){
        int[] arr = new int[1000];
        int pathLen = 0;
        printPaths(root, arr, pathLen);
    }

    public static void printPaths(Node node, int[] path, int pathLen){
        if(node == null)
            return;

        // save data
        path[pathLen++] = node.data;

        // reach leaf, print
        if(node.left == null && node.right == null)
            printArray(path, pathLen);

        // go left and right
        printPaths(node.left, path, pathLen);
        printPaths(node.right, path, pathLen);
    }

    public static void printArray(int[] path, int pathLen){
        for(int i = 0; i < pathLen; i++){
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }
}
