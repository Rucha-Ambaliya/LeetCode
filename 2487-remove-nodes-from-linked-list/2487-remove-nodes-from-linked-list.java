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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode currNode = head;
        while(currNode != null){
            stack.push(currNode.val);
            currNode = currNode.next;
        }
        
        int max = Integer.MIN_VALUE;
        ListNode newHead = null;
        
        while (!stack.isEmpty()) {
            int val = stack.pop();
            if (val >= max) {
                max = val;
                ListNode temp = newHead;
                newHead = new ListNode(val);
                newHead.next = temp;
            }
        }
        
        return newHead;
    }
}