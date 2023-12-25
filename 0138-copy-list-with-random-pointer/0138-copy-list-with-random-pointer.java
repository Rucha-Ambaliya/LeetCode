/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node head2 = new Node(-1);
        Node h2 = head2;
        Node h1 = head;
        while(h1 != null) {
            Node newNode = new Node(h1.val);
            h2.next = newNode;
            h2 = h2.next;
            h1 = h1.next;
        }
        head2 = head2.next;
        h2 = head2;
        h1 = head;
        Node temp = h1;
        while(h2 != null){
            temp = h1.next;
            h1.next = h2;
            h1 = temp;
            temp = h2.next;
            h2.next = h1;
            h2 = temp;
        }
        h2 = head2;
        h1 = head;
        while(h1 != null && h2 != null){
            if(h1.random == null){
                h2.random = null;
            } else {
                h2.random = h1.random.next;
            }
            h1 = h2.next;
            if(h1 == null){
                break;
            }
            h2 = h1.next;
        }
        h2 = head2;
        h1 = head;
        while(h1 != null && h1.next != null){
            h1.next = h2.next;
            h1 = h1.next;
            if(h1 == null){
                break;
            }
            h2.next = h1.next;
            h2 = h2.next;
        }
        return head2;
    }
}