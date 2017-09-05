/*
ctci pg 272
time - O(n)
space - O(log n) due to hash table
*/

int countPathsWithSum(TreeNode root, int targetSum){
    return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
}

int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount){
    if(node == null) return 0;
    runningSum += node.data;
    int sum = runningSum - targetSum;
    int totalPaths = pathCount.getOrDefault(sum, 0);

    if(runningSum == targetSum)
        totalPaths++;

    incrementHashTable(pathCount, runningSum, 1);
    totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
    totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
    incrementHashTable(pathCount, runningSum, -1);

    return totalPaths;
}

void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta){
    if(newCount == 0)
        hashTable.remove(key);
    else
        hashTable.put(key, newCount);
}
