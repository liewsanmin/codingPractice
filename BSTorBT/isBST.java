/**
Suppose you have helper functions minValue() and maxValue() that return the min
or max int value from a non-empty tree (see problem 3 above). Write an isBST()
function that returns true if a tree is a binary search tree and false
otherwise. Use the helper functions, and don't forget to check every node in
the tree. It's ok if your solution is not very efficient.
Returns true if a binary tree is a binary search tree.

algo 1 :  for each subtree, return false if max of left is larger or min of right
        <= node.data

        time -- O(n) n - number of nodes
        space - O(n)

        edge -- null node, return true


algo 2 : have a recursive variable of min and max
         when recurse left, update max
         when recurse right, update min
         DFS walkthrough

         time - O(n)
         space - O(log n) on a balanced tree
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
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(7);
        root.left.right = new Node(6);

        System.out.println(isBST(root, null, null));
    }

    // algo 1
    public static boolean isBST(Node node){
        if(node == null)
            return true;

        if(node.left != null && maxValue(node.left) > node.data)
            return false;
        if(node.right != null && minValue(node.right) <= node.data)
            return false;

        return isBST(node.left) && isBST(node.right);
    }

    // algo 2
    public static boolean isBST(Node node, Integer min, Integer max){
        if(node == null)
            return true;

        if((min != null && node.data <= min) || (max != null && node.data > max))
            return false;

        if(!isBST(node.left, min, node.data) || (!isBST(node.right, node.data, max)))
            return false;
        return true;
    }
}
