class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> path_p = new ArrayList<>();
        List<TreeNode> path_q = new ArrayList<>();

        getPath(path_p, root, p);
        getPath(path_q, root, q);

        int n = Math.min(path_p.size(), path_q.size());

        TreeNode lca = null;

        for(int i = 0; i < n; i++){
            if(path_p.get(i) == path_q.get(i))
                lca = path_p.get(i);
            else
                break;
        }

        return lca;
    }

    public void getPath(List<TreeNode> list, TreeNode node, TreeNode key) {

        if(node == null)
            return;

        list.add(node);

        if(node == key)
            return;

        getPath(list, node.left, key);
        getPath(list, node.right, key);

        if(!list.isEmpty() && list.get(list.size() - 1) != key)
            list.remove(list.size() - 1);
    }
}
