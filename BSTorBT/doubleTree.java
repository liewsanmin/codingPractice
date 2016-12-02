/**
For each node in a binary search tree, create a new duplicate node, and insert the duplicate as the left child of the original node. The resulting tree should still be a binary search tree.
 So the tree... 
    2 
   / \ 
  1   3

 is changed to... 
       2 
      / \ 
     2   3 
    /   / 
   1   3 
  / 
 1

BOTTOM-UP APPROACH
1. base case when reach null, return
2. take current value & left node
3. set left = null
4. set left data = current data
5. set left.left = left node
6. go left and go right

time - O(n)
space - O(n)

edge - null input

*/
class Node{
    int data;
    Node left, right;
    public Node(int item){
        data = item;
        left = right = null;
    }
}
public class Solution{
    public static void main(String[] args){
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        
        doubleTree(root);
        printPreOrder(root);
    }
    
    public static void printPreOrder(Node node){
         
        if(node == null)
            return;
        
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    
    public static void doubleTree(Node node){
        if(node != null){
            doubleTree(node.left);
            doubleTree(node.right);
            
            Node oldLeft = node.left;
            node.left = new Node(node.data);
            node.left.left = oldLeft;
        }
    }
}
