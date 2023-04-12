package dsa.Tree;

import userUtil.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC144 {
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if (root == null)
            return;

        helper(root.left, res);
        helper(root.right, res);
    }

    public List<Integer> preorderTraversalIterative(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode curr;

        while (!stack.isEmpty()){
            curr = stack.pop();
            res.add(curr.key);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
        return res;
    }
}
