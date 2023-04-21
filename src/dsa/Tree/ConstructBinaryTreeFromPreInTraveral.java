package dsa.Tree;

import userUtil.TreeNode;
import java.util.HashMap;

public class ConstructBinaryTreeFromPreInTraveral {
        private int preIdx = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> inOrderMap = new HashMap<>();
            int n = inorder.length;
            for (int i = 0; i < n; i++)
                inOrderMap.put(inorder[i], i);
            System.out.println("Set view:" + inOrderMap.entrySet());
            return helper(preorder, inOrderMap, 0, n - 1);
        }

        private TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int inStart, int inEnd){
            if (preIdx >= preorder.length || inStart > inEnd)
                return null;

            TreeNode root = new TreeNode(preorder[preIdx++]);
            System.out.println(root.val);
            int index = map.get(root.val);
            root.left = helper(preorder, map, inStart, index - 1);
            root.right = helper(preorder, map, index + 1, inEnd);
            return root;

    }
}
