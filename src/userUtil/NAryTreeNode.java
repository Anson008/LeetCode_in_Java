package userUtil;
import java.util.ArrayList;
import java.util.List;

public class NAryTreeNode {
    public int val;
    public List<NAryTreeNode> children;

    public NAryTreeNode(int val, List<NAryTreeNode> children){
        this.val = val;
        this.children = new ArrayList<>(children);
    }
}
