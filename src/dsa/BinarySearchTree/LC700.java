package dsa.BinarySearchTree;

import userUtil.TreeNode;

public class LC700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (val < root.val)
            return searchBST(root.left, val);
        if (val > root.val)
            return searchBST(root.right, val);
        return root;
    }
}
