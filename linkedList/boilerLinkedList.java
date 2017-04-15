/**
Boiler Plate for linkedlist
*/

class Node{
    int data;
    Node next;
    Node(int item){
        data = item;
        next = null;
    }
}
public class Solution{
    public static void main(String[] args){
        Node p1 = new Node(1);
        p1.next = new Node(3);
        Node p2 = new Node(0);

    }
    public static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
