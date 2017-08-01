/*
Given a binary tree, design an algo which creates a linkedlist of all the nodes
at each depth, (eg. if you have tree with depth D, you'll have D linked lists)
*/

// solution 1, bfs, root > level 2 > level 3 etc
//time O(n)
//space O(n) returning data
ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
    // visit the root
    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    if(root != null)
        current.add(root);
    while(current.size() > 0){
        result.add(current);
        LinkedList<TreeNode> parents = current;
        current = new LinkedList<TreeNode>();
        for(TreeNode parent : parents){
            if(parent.left != null)
                current.add(parent.left);
            if(parent.right != null)
                current.add(parent.right);
        }
    }
    return result;
}


//solution 2, dfs, simple modification of the pre-order traversal algo

void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists,
int level){
    if(root == null)
        return; //base case

    LinkedList<TreeNode> list = null;
    if(lists.size() == level){ // level not contained in list
        list = new LinkedList<TreeNode>();
        lists.add(list);
    } else {
        list = lists.get(level);
    }
    list.add(root);
    createLevelLinkedList(root.left, lists, level + 1);
    createLevelLinkedList(root.right, lists, level + 1);
}

ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
    createLevelLinkedList(root, lists, 0);
    return lists;
}
