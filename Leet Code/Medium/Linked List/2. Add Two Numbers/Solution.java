/* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list. You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

Link: https://leetcode.com/problems/add-two-numbers/ */

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        
        if(l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode it = dummy;
        int carry = 0;
        int sum = 0;
        
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            ListNode current = new ListNode(sum % 10);
            carry = sum / 10;
            it.next = current;
            it = it.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
            sum = l1.val + carry;
            ListNode current = new ListNode(sum % 10);
            carry = sum / 10;
            it.next = current;
            it = it.next;
            l1 = l1.next;
        }
        
        while(l2 != null) {
            sum = l2.val + carry;
            ListNode current = new ListNode(sum % 10);
            carry = sum / 10;
            it.next = current;
            it = it.next;
            l2 = l2.next;
        }
        
        if(carry != 0) {
            ListNode current = new ListNode(carry);
            it.next = current;
        }
        
        return dummy.next;
    }
}