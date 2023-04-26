package dsa.BinarySearchTree;

import userUtil.TreeNode;

public class LC1038 {
    private int prefix = 0;
    public TreeNode bstToGst(TreeNode root) {
        reversedInOrder(root);
        return root;
    }

    private void reversedInOrder(TreeNode root){
        if (root == null)
            return;

        reversedInOrder(root.right);
        root.val += prefix;
        prefix = root.val;
        reversedInOrder(root.left);
    }
}
