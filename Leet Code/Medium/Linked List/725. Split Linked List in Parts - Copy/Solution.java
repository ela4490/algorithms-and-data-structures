/* Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
    
Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/ */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        
        dummy.next = head;
        ListNode prev = dummy;
        
        while(current != null && current.next != null) {
            boolean found = false;
            
            while(current != null && current.next != null && current.val == current.next.val) {
                found = true;
                current = current.next;
            }
            
            if(!found) {
                prev = prev.next;
            } else {
                prev.next = current.next;
            }
            
            current = current.next;
        }
        
        return dummy.next;
    }
}