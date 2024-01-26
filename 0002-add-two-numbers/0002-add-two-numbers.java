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
        ListNode ansNode = getAns(l1, l2);
        return ansNode;
    }
    public ListNode getAns(ListNode l1, ListNode l2){
        ListNode L3 = new ListNode(-1);
        ListNode l3 = L3;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if(sum <= 9){
                ListNode newNode = new ListNode(sum);
                l3.next = newNode;
                l3 = newNode;
            }
            else{
                int d = sum % 10;
                ListNode newNode = new ListNode(d);
                sum = sum/10;
                carry = sum % 10;
                l3.next = newNode;
                l3 = newNode;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            carry = 0;
            if(sum <= 9){
                ListNode newNode = new ListNode(sum);
                l3.next = newNode;
                l3 = newNode;
            }
            else{
                int d = sum % 10;
                ListNode newNode = new ListNode(d);
                sum = sum/10;
                carry = sum % 10;
                l3.next = newNode;
                l3 = newNode;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            carry = 0;
            if(sum <= 9){
                ListNode newNode = new ListNode(sum);
                l3.next = newNode;
                l3 = newNode;
            }
            else{
                int d = sum % 10;
                ListNode newNode = new ListNode(d);
                sum = sum/10;
                carry = sum % 10;
                l3.next = newNode;
                l3 = newNode;
            }
            l2 = l2.next;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
            l3 = newNode;
        }
        return L3.next;
    }
}