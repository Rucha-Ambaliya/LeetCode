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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode pre = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
    public int pairSum(ListNode head){
        ListNode h = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = reverse(slow.next);
        slow.next = null;
        int sum = mid.val + h.val;
        while(h.next != null) {
            mid = mid.next;
            h = h.next;
            if((mid.val + h.val) > sum){
                sum = mid.val + h.val;
            }
        }
        return sum;
    }
}