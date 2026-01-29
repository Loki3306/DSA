import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        findNode(root, st1, p.val);
        findNode(root, st2, q.val);

        TreeNode lca = null;

        int i = 0;
        int n = Math.min(st1.size(), st2.size());

        while(i < n && st1.get(i) == st2.get(i)){
        lca = st1.get(i);
        i++;
        }

        return lca;
    }

    public void findNode(TreeNode node, Stack<TreeNode> st, int key) {
        while(node != null){
        st.push(node);

        if(node.val == key) return;
        else if(key < node.val) node = node.left;
        else node = node.right;
        }
    }
}
