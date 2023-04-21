package dsa.BinarySearchTree;

import userUtil.TreeNode;

public class LC270 {
    private double minDiff = Double.MAX_VALUE;
    private int res;
    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, double target){
        if (root == null)
            return;

        if (Math.abs(root.val - target) < minDiff){
            minDiff = Math.abs(root.val - target);
            res = root.val;
        }
        if (target < root.val)
            dfs(root.left, target);
        else
            dfs(root.right, target);
    }
}
