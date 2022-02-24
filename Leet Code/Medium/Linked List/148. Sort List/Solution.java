/* Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is in the range [0, 5 * 10^4].
-10^5 <= Node.val <= 10^5

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
    
Link: https://leetcode.com/problems/sort-list/ */

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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next ==null) {
			return head;
		}
        
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev= null;
		
        while(fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next;
			slow = slow.next;
			
            if(fast != null) {
				fast = fast.next;
			}
		}
        
		prev.next = null;

		ListNode first = sortList(head);
		ListNode  second = sortList(slow);

		return merge(first, second);
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
		if(head1 ==null) {
			return head2;
		}
        
		if(head2 ==null) {
			return head1;
		}

		ListNode dummy = new ListNode(-1);
		ListNode it = dummy;

		while(head1 != null && head2 != null) {
			
            if(head1.val < head2.val) {
				it.next = head1;
				head1 = head1.next;
				it = it.next;
			} else {
				it.next = head2;
				head2 = head2.next;
				it = it.next;
			}
            
		}

		while(head1 != null) {
			it.next = head1;
			head1 = head1.next;
			it = it.next;
		}

		while(head2!=null) {
			it.next = head2;
			head2 = head2.next;
			it = it.next;
		}

		return dummy.next;
	}
}