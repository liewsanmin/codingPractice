TreeNode inorderSucc(TreeNode n){
    if(n == null)
        return null;
    if(n.right != null){
        TreeNode curr = n.right;
        while(curr != null)
            curr = curr.left;
        return curr;
    }
    else{
        TreeNode x = n.parent;
        TreeNode curr = n;
        while(x.left != curr && x != null){
            curr = x;
            x = x.parent;
        }
        return x;
    }
}
