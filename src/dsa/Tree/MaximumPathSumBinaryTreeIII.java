package dsa.Tree;

import userUtil.TreeNode;

public class MaximumPathSumBinaryTreeIII {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode root){
        if (root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        maxSum = Math.max(maxSum, Math.max(root.key, Math.max(root.key + left, root.key + right)));
        return Math.max(root.key, Math.max(root.key + left, root.key + right));
    }
}
