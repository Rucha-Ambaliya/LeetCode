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
        ListNode h = head;
        ListNode t = head;
        int Val = head.val;
        
        while(t.next != null) {
            while (t != null && t.val == Val) {
                t = t.next;
            }
            if(t == null) {
                h.next = t;
                return head;
            }
            h.next = t;
            h = h.next;
            Val = t.val;
        }
        return head;
    }
}