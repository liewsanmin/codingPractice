/*
    given a sorted array with integer, write an algo to create a binary search
    tree with minimal height

*/
TreeNode createMinimalBST(int arr[]){
    createMinimalBST(arr, 0, arr.length - 1);
}

TreeNode createMinimalBST(int arr[], int start, int end){
    if(start > end)
        return null;
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(arr[mid]);
    node.left = createMinimalBST(arr, 0, mid - 1);
    node.right = createMinimalBST(arr, mid + 1, arr.length);
    return node;
}
