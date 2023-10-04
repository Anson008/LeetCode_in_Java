package dsa.LinkedList;

import userUtil.ListNode;

public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode fakeHead = new ListNode(-1), curr = fakeHead;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
        }
        if (carry > 0)
            curr.next = new ListNode(carry);
        return fakeHead.next;
    }
}
