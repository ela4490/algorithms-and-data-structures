/* Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n

Follow up: Could you do it in one pass?

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3789/ */

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return null;
        ListNode prev = null;
        ListNode current_node = head;
        while(left>1){
            prev = current_node;
            current_node = current_node.next;
            left--;
            right--;
        }
        ListNode connection = prev;
        ListNode tail = current_node;
        while(right>0){
            ListNode next_node = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = next_node;
            right--;
        }
        if(connection!=null){
            connection.next = prev;
        }else{
            head = prev;
        }
        tail.next = current_node;
        
        return head;
    }
}