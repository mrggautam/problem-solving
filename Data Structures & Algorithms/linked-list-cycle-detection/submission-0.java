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
    public boolean hasCycle(ListNode head) {

        ListNode slow= head;
        ListNode fast= head.next;

        while(fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow == fast;
        
    }
}
