/**
Write a function to see if a binary tree ↴ is "superbalanced" (a new tree property we just made up).
A tree is "superbalanced" if the difference between the depths of any two leaf nodes ↴ is no greater than one.

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}


public class NodeDepthPair{
    BinaryTreeNode node;
    int depth;

    public NodeDepthPair(BinaryTreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}

public class isBTbalanced{
    public static boolean isBalanced(BinaryTreeNode treeRoot){
        // a tree with no nodes is superbalanced, since there are no leaves!
        if(treeRoot == null)
            return true;

        List<Integer> depths = new ArrayList<Integer>(3);
        Stack<NodeDepthPair> nodes = new Stack<NodeDepthPair>();
        nodes.push(new NodeDepthPair(treeRoot, 0));

        while(!nodes.empty()){
            NodeDepthPair nodeDepthPair = nodes.pop();
            BinaryTreeNode node = nodeDepthPair.node;
            int depth = nodeDepthPair.depth;

            if(node.left == null && node.right == null){
                if(!depths.contains(depth)){
                    depths.add(depth);
                    System.out.println(depths.size());
                    if(depths.size() > 2 ||
                       (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1))
                       return false;
                }
            }
            else{
                if(node.left != null)
                    nodes.push(new NodeDepthPair(node.left, depth + 1));
                if(node.right != null)
                    nodes.push(new NodeDepthPair(node.right, depth +1));
            }
        }
        return true;
    }

    public static void main(String[] args){
        BinaryTreeNode root = new BinaryTreeNode(0);
        root.insertRight(1);
        root.right.insertRight(1);
        root.right.right.insertRight(1);
        root.insertLeft(2);

        System.out.println(isBalanced(root));
    }
}
