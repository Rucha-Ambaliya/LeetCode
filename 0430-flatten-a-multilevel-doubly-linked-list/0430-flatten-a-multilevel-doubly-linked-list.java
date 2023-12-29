class Solution {

    public Node flatten(Node head) {
        if(head == null){
            return null;
        }
        Node h = head;
        Node dummy = new Node(0);
        Node t = dummy;

        while (h != null) {
            if (h.child != null) {
                Node newChild = new Node(h.val);
                t.next = newChild;
                newChild.prev = t;
                t = getChild(h.child, t.next);
                h = h.next;
            } else {
                Node newNode = new Node(h.val);
                t.next = newNode;
                newNode.prev = t;
                t = t.next;
                h = h.next;
            }
        }
        dummy.next.prev = null;
        return dummy.next;
    }

    public Node getChild(Node ch, Node t) {
        while (ch != null) {
            Node newChild = new Node(ch.val);
            t.next = newChild;
            newChild.prev = t;
            t = t.next;

            if (ch.child != null) {
                t = getChild(ch.child, t);
            }

            ch = ch.next;
        }

        return t;
    }
}
