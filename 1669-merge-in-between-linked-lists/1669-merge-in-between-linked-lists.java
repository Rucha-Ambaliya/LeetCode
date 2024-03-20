class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1; // Node before section to be replaced
        ListNode end = list1; // Node after section to be replaced
        ListNode tailOfList2 = list2; // Tail of list2

        // Move start and end to nodes before and after the section to be replaced
        for (int i = 1; i < a; i++) {
            start = start.next;
            end = end.next;
        }
        for (int i = 0; i <= b - a; i++) {
            end = end.next;
        }

        // Move tailOfList2 to the end of list2
        while (tailOfList2.next != null) {
            tailOfList2 = tailOfList2.next;
        }

        // Connect start to list2, and list2 to end
        start.next = list2;
        tailOfList2.next = end.next;

        return list1;
    }
}
