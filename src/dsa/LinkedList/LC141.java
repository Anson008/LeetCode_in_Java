package dsa.LinkedList;

import userUtil.ListNode;

public class LC141 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
