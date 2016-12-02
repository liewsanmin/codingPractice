/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Top-down approach
 * 1. both node are on the left sub tree 
 * 2. both node are on the right sub tree
 * 3. one on left and one on right sub tree
 * 4. one of the node is equal to p or q
 * 
 * if node is in left -> go left
 * if node in right -> go right
 * else return root
 * 
 *
 * since not bst -> keep recursing left / right until found p or q -- via a helper method
 * time -- O(n^2) when n is height of tree, and tree could be degenerate
 * space -- O(n^2) since each recursion takes up a space
 * 
 * edge case - when root is null return false (helper)
 *              root or p or q is null, return null (main)
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        // check if p & q in left tree
        if(search(root.left, p) && search(root.left, q))
            return lowestCommonAncestor(root.left, p, q);
            
        if(search(root.right, p) && search(root.right, q))
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
    
    public boolean search(TreeNode node, TreeNode target){
        if(node == null)
            return false;
        if(node == target)
            return true;
        else 
            return search(node.left, target) || search(node.right, target);
    }
    
/**
 *Optimize -- bottom-up approach
 * using power of true && true
 * recurse the tree only once to get the element
 * when found return true
 * before going up one level, that level's left and right must be true
 *      else return false
 * 
 * time -- O(n) n = height
 * space -- O(n)
 */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return null;
        if(root == p || root == q)
            return root;
            
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null)
            return root;
        
        return left != null ? left : right;
    }
}
