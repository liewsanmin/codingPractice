/**
Merge two sorted linked lists and return it as a new list. The new list
should be made by splicing together the nodes of the first two lists.

algo 1: Recursive
time - O(n)
space - O(n^2)

algo 2: iterative
have a fake head that points to 0
have a pointer that points to fake head
while both p1 and p2 not null, add whichever is lower
when one of them null, add the not null one to the next of that pointer that points
to fake head

time - O(n)
space - O(n)
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

        Node ans = mergeSortedList(p1, p2);
        printList(ans);
    }
    public static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // algo 1
    public static Node mergeSortedList(Node p1, Node p2){
        if(p1 == null)
            return p2;
        else if(p2 == null)
            return p1;

        if(p1.data < p2.data){
            p1.next = mergeSortedList(p1.next, p2);
            return p1;
        }
        else{
            p2.next = mergeSortedList(p1, p2.next);
            return p2;
        }
    }

    //algo 2
    static Node mergeSortedList(Node n1, Node n2){
        // fake head
        Node head = new Node(0);
        Node p = head;
        Node p1 = n1;
        Node p2 = n2;
        while(p1 != null && p2 != null){
            if(p1.data < p2.data){
                p.next = p1;
                p1 = p1.next;
            }
            else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if(p1 != null)
            p.next = p1;

        if(p2 != null)
            p.next = p2;

        return head.next;
    }
}
