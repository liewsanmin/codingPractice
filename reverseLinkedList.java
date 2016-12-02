/**
Reverse a singly linked list.

algo:
have a new head set to null
a pointer set to oldHead
set that pointer to new head(null)
new head's pointer go to next
old head pointer go to next

time - O(n)
space - O(1)

edge - null inputs
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
        p1.next.next = new Node(4);

    }
    public static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static Node reverseLinkedList(Node head){
        Node curr = head;
        Node prev = null;
        while(curr != null){
            Node tmp = curr;
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
