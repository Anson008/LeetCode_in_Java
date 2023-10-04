package dsa.LinkedList;

import userUtil.ListNode;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode curr = head;
        ListNode nextNode;

        while (curr != null) {
            nextNode = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = nextNode;
        }
        return newHead;
    }
}
