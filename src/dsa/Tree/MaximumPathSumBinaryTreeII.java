package dsa.Tree;

import userUtil.TreeNode;

public class MaximumPathSumBinaryTreeII {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode root){
        if (root == null)
            return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        maxSum = Math.max(maxSum, left + right + root.key);

        return Math.max(left, right) + root.key;
    }
}
