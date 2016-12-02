/**
Given values of two nodes in a Binary Tree, find the Lowest Common Ancestor
(LCA). It may be assumed that both nodes exist in the tree.

Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2
is defined as the lowest node in T that has both n1 and n2 as descendants
(where we allow a node to be a descendant of itself). Source : Wikipedia.

algo 1 :    using hash table store all of n1's ancestors in the table until its
            root, for n2
            traverse its parents until table consist that point, then return
            if still not found, return null
            time - O(h) h - depth of tree
            space - O(h)

algo 2 :    idea is the levels and 2 pointers
            find depth of both nodes
            find difference between 2 depths of nodes

            to get both pointers to reach the same levels, traverse the deeper
            pointer until difference is zero, then traverse both pointers up
            until both nodes are equal then return one of the nodes

            time - O(h)
            space - O(1)

edge case : null node, no lca

*/
class Node{
    int data;
    Node left, right, parent;
    public Node(int item){
        data = item;
        left = right = parent = null;
    }
}
public class Solution{
    public static void main(String[] args){
        Node root = new Node(2);
        root.right = new Node(3);
        root.left = new Node(1);
        root.left.parent = root;
        root.right.parent = root;
        root.right.right = new Node(4);
        root.right.right.parent = root.right;

        Node n1 = root.right.right;
        Node n2 = root.right.right;
        System.out.println(lca(n1,n2).data);

    }

    public static Node lca(Node n1, Node n2){
        if(n1 == null || n2 == null)
            return null;
        int depth1 = depth(n1);
        int depth2 = depth(n2);
        int diff = Math.abs(depth1 - depth2);

        // if depth2 is deeper, swap n1 and n2
        if(depth2 > depth1){
            Node temp = n1;
            n1 = n2;
            n2 = temp;
        }

        Node point1 = n1;
        Node point2 = n2;
        while(diff-- != 0){
            point1 = point1.parent;
        }

        while(point1 != null && point2 != null){
            if(point1 == point2)
                return point1;
            point1 = point1.parent;
            point2 = point2.parent;
        }

        return null;
    }

    public static int depth(Node node){
        // the parent of root is null, as with child of leaf
        int depth = -1;
        while(node != null){
            depth++;
            node = node.parent;
        }
        return depth;
    }
}
