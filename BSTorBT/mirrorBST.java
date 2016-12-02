/**
hanges the tree into its mirror image.

 So the tree...
       4
      / \
     2   5
    / \
   1   3

 is changed to...
       4
      / \
     5   2
        / \
       3   1

use a recursive helper to swap them

1. base case both null, return
2. else swap both
3. then recurse left
4. then recurse right

time -- O(n) n = number of elements
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

        printPreOrder(root);
        System.out.println();
        mirror(root);
        printPreOrder(root);
    }

    public static void printPreOrder(Node node){
        if(node == null)
            return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void mirror(Node node){
        if(node != null){
            mirror(node.left);
            mirror(node.right);

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
}
