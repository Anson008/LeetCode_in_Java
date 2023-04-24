package dsa.BinarySearchTree;

import userUtil.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC99 {
    public void recoverTree(TreeNode root){
        TreeNode first = null, second = null, prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev.val){
                second = root;
                if (first == null)
                    first = prev;
            }
            prev = root;
            root = root.right;
        }
        swap(first, second);
    }

    private void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
