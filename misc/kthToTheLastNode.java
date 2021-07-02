/**
    2
    length = 5
    a - b - c - d - e - null
                        ^
                `

First approach: use the length of the list.

walk down the whole list, counting nodes, to get the total listLength.
subtract kk from the listLength to get the distance from the head node to the
 target node (the kth to last node).
walk that distance from the head to arrive at the target node.
*/
  public LinkedListNode kthToLastNode(int k, LinkedListNode head) {

    if (k < 1) {
        throw new IllegalArgumentException("Impossible to find less than first to last node: " + k);
    }

    // STEP 1: get the length of the list
    // start at 1, not 0
    // else we'd fail to count the head node!
    int listLength = 1;
    LinkedListNode currentNode = head;

    // traverse the whole list,
    // counting all the nodes
    while (currentNode.next != null) {
        currentNode = currentNode.next;
        listLength += 1;
    }

    // if k is greater than the length of the list, there can't
    // be a kth-to-last node, so we'll return an error!
    if (k > listLength) {
        throw new IllegalArgumentException("k is larger than the length of the linked list: " + k);
    }

    // STEP 2: walk to the target node
    // calculate how far to go, from the head,
    // to get to the kth to last node
    int howFarToGo = listLength - k;

    currentNode = head;
    for (int x = 0; x < howFarToGo; x++) {
        currentNode = currentNode.next;
    }

    return currentNode;
}
