package dsa.BinarySearchTree;

import userUtil.TreeNode;

public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;
        else {
            root.val = findMin(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int findMin(TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }
}
