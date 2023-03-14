package userUtil;
public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key){
        this.key = key;
    }
    public TreeNode(int key, TreeNode left, TreeNode right){
        this.key = key;
        this.left = left;
        this.right = right;
    }

}
