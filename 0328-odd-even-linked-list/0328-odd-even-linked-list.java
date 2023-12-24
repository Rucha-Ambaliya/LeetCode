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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode E = new ListNode(1);
        ListNode even = E;
        ListNode h = head;
        while(h.next != null && h.next.next != null) {
            even.next = h.next;
            even = even.next;
            h.next = h.next.next;
            h = even.next;
        }
        if(h.next != null && h.next.next == null) {
            even.next = h.next;
            h.next = E.next;
            return head;
        }
        even.next = null;
        h.next = E.next;
        return head;
    }
}