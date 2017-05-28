/**
Write a function to find the 2nd largest element in a binary search tree

variables during recursion : prev
4 cases :
    prev != null
    right == null
    left == null ==> return prev

    right == null
    left != null ==> return rightmost of left

    prev null
    right null
    left null ==> null

    edge null ==> null

time -   O(h) time  O(lgn) if the tree is balanced, O(n) otherwise
space -  O(h) space  O(lgn) if the tree is balanced, O(n) otherwise

algo 2:
        use iterative instead of recursive
        since only traversing right, just traverse right iteratively

        time -   O(h); O(lgn) if the tree is balanced, O(n) otherwise
                 h = height of tree
        space -  O(1)
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
        root.right = new Node(8);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);

        // System.out.println(secondLargest(root, null));
        System.out.println(secondLargest(root));
    }

    ///////////////////////////////////////////////////////////////////////////
    // algo 1:
    public static int secondLargest(Node node, Node prev){
        if(node == null)
            return -999; // assuming range does not go that far

        if(prev == null && node.right == null && node.left == null)
            return -999;

        if(prev != null && node.right == null && node.left == null)
            return prev.data;

        if(node.right == null && node.left != null)
            return rightMost(node.left).data;

        return secondLargest(node.right, node);
    }

    public static Node rightMost(Node node){
        if(node == null)
            return null;
        if(node.right == null && node.left == null)
            return node;
        return rightMost(node.right);
    }
    ///////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////
    //algo 2:
    public static int secondLargest(Node node){
        if(node == null || (node.right == null && node.left == null))
            throw new IllegalArgumentException("Tree must have at least 2 nodes");

        Node curr = node;
        Node prev = curr;

        while(curr.right != null || curr.left != null){
            if(curr.right == null && curr.left != null)
                return (rightMost(curr.left)).data;
            prev = curr;
            curr = curr.right;
        }

        return prev.data;
    }

    public static Node rightMost(Node node){
        if(node == null)
            return null;

        Node curr = node;
        while(curr.right != null || curr.left != null){
            curr = curr.right;
        }
        return curr;
    }

    ///////////////////////////////////////////////////////////////////////////
    // algo2 alternative way of writing
    public static int secondLargest(Node node){
        if(node == null || (node.right == null && node.left == null))
            throw new IllegalArgumentException("Tree must have at least 2 nodes");


        Node curr = node;

        while(true){
            if (curr.left != null && curr.right == null) {
                return largest(curr.left);
            }

            if(curr.right != null && curr.right.right == null &&
               curr.right.left == null)
               return curr.data;

            curr = curr.right;
        }
    }

    public static int largest(Node node){
        Node curr = node;
        while(curr.right != null){
            curr = curr.right;
        }

        return curr.data;
    }
    ///////////////////////////////////////////////////////////////////////////
}
