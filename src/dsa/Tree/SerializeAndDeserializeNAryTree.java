package dsa.Tree;//import userUtil.TreeNode;
import userUtil.NAryTreeNode;

import java.util.*;


public class SerializeAndDeserializeNAryTree {
    public String serialize(NAryTreeNode root){
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return String.join(",", res);
    }

    private void dfs(NAryTreeNode root, List<String> res){
        if (root == null)
            return;
        res.add(String.valueOf(root.val));
        res.add(String.valueOf(root.children.size()));
        for (NAryTreeNode node : root.children)
            dfs(node, res);
    }

    public NAryTreeNode deserialize(String data){
        if (data == null || data.isEmpty())
            return null;

        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(q);
    }

    private NAryTreeNode dfs(Queue<String> q){
        if (q.isEmpty())
            return null;

        NAryTreeNode root = new NAryTreeNode(Integer.parseInt(q.poll()), new ArrayList<>());
        int size = Integer.parseInt(q.poll());
        for (int i = 0; i < size; i++)
            root.children.add(dfs(q));
        return root;
    }
}
