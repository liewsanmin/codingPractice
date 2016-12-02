/**
A boiler plate code for BST
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
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        printPreOrder(root);
    }

    public static void printPreOrder(Node node){

        if(node == null)
            return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
