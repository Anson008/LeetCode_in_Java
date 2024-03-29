package dsa.BinarySearchTree;

import userUtil.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> q = new ArrayDeque<>();

        inorder(root, q);

        while (q.size() > k)
            if (Math.abs(q.peekFirst() - target) > Math.abs(q.peekLast() - target))
                q.pollFirst();
            else
                q.pollLast();

        return new ArrayList<>(q);
    }

    private void inorder(TreeNode root, Deque<Integer> q) {
        if (root == null)
            return;

        inorder(root.left, q);
        q.addLast(root.val);
        inorder(root.right, q);
    }
}
