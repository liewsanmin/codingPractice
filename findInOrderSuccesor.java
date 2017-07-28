/*
In a Binary Search Tree (BST), an Inorder Successor of a node is defined as the
node with the smallest key greater than the key of the input node (see examples
below). Given a node inputNode in a BST, you’re asked to write a function
findInOrderSuccessor that returns the Inorder Successor of inputNode. If
inputNode has no Inorder Successor, return null.
*/


import java.io.*;
import java.util.*;

Node findInOrderSuccessor(Node inputNode) {
// your code goes here

  if(inputNode.right != null){ // case 1
    Node curr = inputNode.right;
    while(curr.left != null){
      curr = curr.left
    }
    return curr;
  }
    // case 2
    Node parent = inputNode.parent;
    Node child = inputNode;

    while(parent != null && child == parent.right){
      child = parent;
      parent = child.parent;
    }
    return parent;
}
