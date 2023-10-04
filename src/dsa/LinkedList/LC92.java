package dsa.LinkedList;

import userUtil.ListNode;

public class LC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode curr = head;

        int i = 1;
        while (i < left) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode node = prev;
        ListNode nextNode;
        while (i++ <= right){
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        node.next.next = curr;
        node.next = prev;
        return fakeHead.next;
    }
}
