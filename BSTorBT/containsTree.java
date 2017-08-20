/*
check if T2 is a subtree of T1

time and space - O(n+m)
*/
boolean containsTree(TreeNode t1, TreeNode t2){
    StringBuilder string1 = new StringBuilder();
    StringBuilder string2 = new StringBuilder();

    getOrderString(t1, string1);
    getOrderString(t2, string2);

    return string1.indexOf(string2.toString()) != -1;
}

void getOrderString(TreeNode node, StringBuilder sb){
    if(node == null){
        sb.append("X");     // add null indicator
        return;
    }
    sb.append(node.data + " ");
    getOrderString(node.left, sb);
    getOrderString(node.right, sb);
}

// alternative
boolean containsTree(TreeNode t1, TreeNode t2){
    if(t2 == null) return true;
    return subTree(t1, t2);
}

boolean subTree(TreeNode r1, TreeNode r2){
    if(r1 == null && r2 == null){
        return true;
    } else if (r1 == null || r2 == null){
        return false;
    } else if (r1.data != r2.data){
        return false;
    } else{
        return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
    }
}
