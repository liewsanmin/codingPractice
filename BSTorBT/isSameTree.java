/**
Given two binary trees, return true if they are structurally identical --
they are made of nodes with the same values arranged in the same way.

preOrder, check the nodes

time - O(n)
space - O(n)

edge - invalid input
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
        Node a = new Node(2);
        a.left = new Node(1);
        a.right = new Node(3);

        Node b = new Node(2);
        if(sameTree(a, b))
            System.out.println("True");
        else
            System.out.println("False");
    }

    public static void printPreOrder(Node node){

        if(node == null)
            return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static boolean sameTree(Node a, Node b){
        if(a == null && b == null)
            return true;
        else if(a == null || b == null)
            return false;

        if(a.data != b.data)
            return false;
        return sameTree(a.left, b.left) && sameTree(a.right, b.right);
    }
}
