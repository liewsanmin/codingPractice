/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /**
  * Create a linked list answer 
  * loop through 2 pointers at the same time and keep track sum
  * add to sum as you iterate through llist
  * 
  * 3 conditions:
  * l1 is null: l2 + carry
  * l2 is null: l1 + carry
  * 
  * sum >= 10: math to get carry
  *         1st digit: l.next
  *         2nd digit: carry
  * 
  * time: O(n)
  * space: O(n)
  * 
  * 1. long lines
  * 2. shorter code
  */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); // to return
        ListNode curr = head; // to iterate and update linkedlist
        int carry = 0;
        int currSum = 0;
        
        /**
         * v1
         */
        while(l1 != null && l2 != null){
            ListNode currNode = new ListNode(0); // latest answer and insert into curr
            currSum = l1.val + l2.val + carry;
            carry = 0;
            if(currSum >= 10){
                int d1 = currSum % 10;
                currSum /= 10;
                carry = currSum % 10;
                currNode.val = d1;
            }
            else
                currNode.val = currSum;
            curr.next = currNode;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            ListNode currNode = new ListNode(0); // latest answer and insert into curr
            currSum = l1.val + carry;
            carry = 0;
            if(currSum >= 10){
                int d1 = currSum % 10;
                currSum /= 10;
                carry = currSum % 10;
                currNode.val = d1;
            }
            else
                currNode.val = currSum;
            curr.next = currNode;
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2 != null){
            ListNode currNode = new ListNode(0); // latest answer and insert into curr
            currSum = l2.val + carry;
            // System.out.println("currSum: " + currSum);
            carry = 0;
            if(currSum >= 10){
                int d1 = currSum % 10;
                currSum /= 10;
                carry = currSum % 10;
                currNode.val = d1;
            }
            else
                currNode.val = currSum;
            curr.next = currNode;
            curr = curr.next;
            l2 = l2.next;
        }
        
        while(carry > 0){
            ListNode currNode = new ListNode(0);
            currNode.val = carry;
            carry = 0;
            curr.next = currNode;
            curr = curr.next;
        }
        
        /**
         * v2
         */
        while(l1 != null || l2 != null || carry > 0){
            ListNode currNode = new ListNode(0);
            if(l1 == null && l2 == null && carry > 0)
                currNode.val = carry;
            else if(l1 == null){  // condition 1
                currSum = l2.val + carry;
                l2 = l2.next;
            }
            else if(l2 == null) { // cond 2
                currSum = l1.val + carry;
                l1 = l1.next;
            }
            else { // cond 3
                currSum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = 0;
            if(currSum >= 10){
                int d1 = currSum % 10;
                currSum /= 10;
                carry = currSum % 10;
                currNode.val = d1;
            }
            else
                currNode.val = currSum;
            curr.next = currNode;
            curr = curr.next;
        }
        
        /**
         * other solutions for reference to improve coding below
         */
        while(l1 != null || l2 != null || carry != 0){
            currSum = 0;
            if(l1 != null){
                currSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                currSum += l2.val;
                l2 = l2.next;
            }
            if(carry != 0){
                currSum += carry;
            }
            carry = currSum / 10;
            curr.next = new ListNode(currSum % 10);
            curr = curr.next;
        }
        
        /**
         * shortest one I can find
         */
        while(l1 != null || l2 != null || carry != 0){
            currSum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = currSum / 10;
            curr = curr.next = new ListNode(currSum % 10);
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }
        
        return head.next;
    }
}
