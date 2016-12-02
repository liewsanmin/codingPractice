/**
We'll define a "root-to-leaf path" to be a sequence of nodes in a tree starting with the root node and proceeding downward to a leaf (a node with no children). We'll say that an empty tree contains no root-to-leaf paths. So for example, the following tree has exactly four root-to-leaf paths:
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

Root-to-leaf paths:
   path 1: 5 4 11 7
   path 2: 5 4 11 2
   path 3: 5 8 13
   path 4: 5 8 4 1

For this problem, we will be concerned with the sum of the values of such a path -- for example, the sum of the values on the 5-4-11-7 path is 5 + 4 + 11 + 7 = 27.

Given a binary tree and a sum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum. Return false if no such path can be found.

Algo : have a recursive helper that has a pathSum and adds that node recursively
        once arrive leaf, return that level's pathSum to be true if equal to int target
        after traversing left and right subtree still no return yet, then return false

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
        root.right.left = new Node(1);
        root.right.right = new Node(3);
        int sum = 9;
        int currSum = 0;
        if(hasPathSum(root, sum, currSum))
            System.out.println("found");
        else
            System.out.println("not found");
    }

    public static boolean hasPathSum(Node node, int sum, int currSum){
        if(node != null){

            currSum += node.data;

            // when reach leaf check with sum
            if(node.left == null && node.right == null){
                return currSum == sum;
            }

            return hasPathSum(node.left, sum, currSum) ||
                   hasPathSum(node.right, sum, currSum);
        }
        return false;
    }
}
