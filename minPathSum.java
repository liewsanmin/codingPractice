/**
Get the root to leaf path in a Binary Tree such that the sum of the node values in that path is minimum among 
all possible root to leaf paths.
*/

class Node{
    int data;
    Node left;
    Node right;
    Node(int item){
        data = item;
        left = null;
        right = null;
    }
}

class Solution{
    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        
        System.out.println(minPathSum(root));
    }
    
    private static int minPathSum(Node node){
        if(node == null)
            return 0;
        
        int sum = node.data;
        int left = minPathSum(node.left);
        int right = minPathSum(node.right);
        
        if(left <= right)
            sum += minPathSum(node.left);
        else
            sum += minPathSum(node.right);
        return sum;
    }
}
