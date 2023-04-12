package dsa.Tree;

import userUtil.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC958 {
    public boolean isCompleteTree(TreeNode root){
        if (root == null)
            return true;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode curr;
        boolean isNotFull = false;

        while (!q.isEmpty()){
            curr = q.poll();
            if (isNotFull && (curr.left != null || curr.right != null))
                return false;
            if (curr.left == null && curr.right != null)
                return false;

            if (curr.left != null)
                q.add(curr.left);
            else
                isNotFull = true;
            if (curr.right != null)
                q.add(curr.right);
            else
                isNotFull = true;
        }
        return true;
    }

}
