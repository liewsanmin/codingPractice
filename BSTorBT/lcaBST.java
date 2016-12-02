/**
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Time -- O(n) -- n = height of binary search tree
Space -- O(1)

*/

class Node{
    int data;
    Node left;
    Node right;
    public  Node(int item){
        data = item;
        left = right = null;
    }
}
class Solution{

    public static void main(String[] args){
        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        Node node1 = new Node(0);
        Node node2 = new Node(9);
        Node ans = lca(root, node1, node2);
        System.out.println(ans.data);
    }

    private static Node lca(Node root, Node node1, Node node2){
        if(root == null)
            return null;

        if(Math.min(node1.data, node2.data) > root.data)
            return lca(root.right, node1, node2);

        else if(Math.max(node1.data, node2.data) < root.data)
           return lca(root.left, node1, node2);
        else
            return root;
    }
}
