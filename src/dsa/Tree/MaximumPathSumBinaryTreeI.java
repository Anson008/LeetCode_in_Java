package dsa.Tree;

import userUtil.TreeNode;

public class MaximumPathSumBinaryTreeI {
    /* */
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

        if (root.left == null){
            return right + root.val;
        }
        if (root.right == null){
            return left + root.val;
        }
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
