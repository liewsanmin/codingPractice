/*
    find common ancestor of binary tree only, not bst
    with links to parents
*/TreeNode commonAncestor(TreeNode p, TreeNode q){
    int delta = depth(p) - depth(q);
    TreeNode first = delta > 0 ? q : p;
    TreeNode second = delta > 0 ? p : q;
    second = goUpBy(second, Math.abs(delta));

    while(first != second && first != null && second != null){
        first = first.parent;
        second = second.parent;
    }

    return first == null || second == null ? null : first;
}

TreeNode goUpBy(TreeNode node, int delta){
    while(delta > 0 && node != null){
        node = node.parent;
        delta--;
    }
    return node;
}

int depth(TreeNode node){
    int depth = 0;
    while(node != null){
        node = node.parent;
        depth++;
    }
    return depth;
}
// better worst case runtime
TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
    if(!covers(root, p) || !covers(root, q )){
        return null;
    } else if(covers(p,q)){
        return p;
    }else if (covers(q,p)){
        return q;
    }

    TreeNode sibling = getSibling(p);
    TreeNode parent = p.parent;
    while(!covers(sibling, q)){
        sibling = getSibling(parent);
        parent = parent.parent;
    }
    return parent;
}

boolean covers(TreeNode root, TreeNode p){
    if(root == null) return false;
    if(root == p) return true;
    return covers(root.left, p) || covers(root.right, p);
}

TreeNode getSibling(TreeNode node){
    if(node == null || node.parent == null)
        return null;
    TreeNode parent = node parent;
    return parent.left == node ? parent.right : parent.left;
}

/*
without links to parents
solution : follow a chain for p and q if they are in the same side
if not, found ancestor

time - O(n)
*/
TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
    if(!covers(root, p) || !covers(root, q))
        return null;

    return ancestorHelper(root, p, q);
}

TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q){
    if(root == null || root == p || root == q)
        return root;
    boolean pIsOnLeft = covers(root.left, p);
    boolean qIsOnLeft = covers(root.left, q);
    if(pIsOnLeft != qIsOnLeft)
        return root;

    TreeNode childSide = pIsOnLeft ? root.left : root.right;
    return ancestorHelper(childSide, p, q);
}

boolean covers(TreeNode root, TreeNode p){
    if(root == null) return false;
    if(root == p) return true;
    return covers(root.left, p) || covers(root.right, p);
}

/*
without parents, optimized
*/
class Result{
    public TreeNode node;
    public boolean isAncestor;
    public Result(TreeNode n, boolean isAnc){
        node = n;
        isAncestor = isAnc;
    }
}

TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
    Result r = commonAncestorHelper(root, p, q);
    if(r.isAncestor)
        return r.node;
    return null;
}

Result commonAncHelper(TreeNode root, TreeNode p, TreeNode q){
    if(root == null) return new Result(null, false);

    if(root == p && root == q)
        return new Result(root, true);

    Result rx = commonAncHelper(root.left, p, q);
    if(rx.isAncestor)
        return rx;

    Result ry  = commonAncHelper(root.right, p, q);
    if(ry.isAncestor)
        return ry;

    if(rx.node != null && ry.node != null){
        return new Result(root, true);
    } else if (root == p || root == q){
        boolean isAncestor = rx.node != null || ry.node != null;
        return new Result(root, isAncestor);
    } else {
        return new Result(rx.node != null ? rx.node : ry.node, false);
    }
}
