/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        int m = 0;
        int n = 0;
        while(h1 != null) {
            m++;
            h1 = h1.next;
        }
        while(h2 != null) {
            n++;
            h2 = h2.next;
        }
        h1 = headA;
        h2 = headB;
        if (m > n) {
            int skipA = m - n;
            for (int i = 0; i < skipA; i++) {
                h1 = h1.next;
            }
        } 
        if(n > m) {
            int skipB = n - m;
            for (int i = 0; i < skipB; i++) {
                h2 = h2.next;
            }
        }
        while(h1 != null) {
            if(h1 == h2) {
                return h1;
            } else {
                h1 = h1.next;
                h2 = h2.next;
            }
        }
        return null;
    }
}