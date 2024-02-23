package dsa.LinkedList;

import java.util.Map;
import java.util.HashMap;

public class LC146 {
    final ListNode head = new ListNode();
    final ListNode tail = new ListNode();
    Map<Integer, ListNode> nodeMap;
    int capacity;

    public LC146(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int res = -1;
        ListNode node = nodeMap.get(key);
        if (node != null) {
            res = node.val;
            remove(node);
            add(node);
        }
        return res;
    }

    public void put(int key, int value) {
        ListNode node = nodeMap.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
            add(node);
        }
        else {
            if (nodeMap.size() == this.capacity){
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }

            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.val = value;
            nodeMap.put(key, newNode);
            add(newNode);
        }
    }

    private void add(ListNode node) {
        ListNode headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
    }

    private void remove(ListNode node) {
        ListNode nextNode = node.next;
        ListNode prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private static class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
    }
}
