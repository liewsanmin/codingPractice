'''
Honda wishes to find the minimal Sales Path cost in its distribution tree. Given
 a node rootNode, write an function getCheapestCost that calculates the minimal
 Sales Path cost in the tree.

Implement your function in the most efficient manner and analyze its time and
space complexities.

For example:

Given the rootNode of the tree in diagram above

Your function would return:

7 since it’s the minimal Sales Path cost (there are actually two Sales Paths in
the tree whose cost is 7: 0→6→1 and 0→3→2→1→1)

Constraints:

[time limit] 5000ms

[input] Node rootNode

0 ≤ rootNode.cost ≤ 100000
[output] integer

'''
def get_cheapest_cost(rootNode):
  return traverse(rootNode, rootNode.cost, float('inf'))

# trying to traverse through children & compare & get the min at each leaf node
def traverse(rootNode, totalCost, minCost):
  # base case
  if rootNode.children == []:
    minCost = min(minCost, totalCost)
    return minCost

  for child in rootNode.children:
    get_cheapest_cost(child, totalCost + rootNode.cost, minCost)
