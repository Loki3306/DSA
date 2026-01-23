/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    TreeNode node;
    int row;
    int col;

    Pair(TreeNode n, int r, int c) {
        node = n;
        row = r;
        col = c;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0, 0));

        List<Pair> nodes = new ArrayList<>();
        while (!q.isEmpty()) {
            Pair p = q.poll();
            nodes.add(p);
            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;

            if (node.left != null)
                q.offer(new Pair(node.left, row + 1, col - 1));
            if (node.right != null)
                q.offer(new Pair(node.right, row + 1, col + 1));
        }

        nodes.sort((a, b) -> {
            if (a.col != b.col)
                return a.col - b.col;
            if (a.row != b.row)
                return a.row - b.row;
            return a.node.val - b.node.val;
        });

        int prevCol = nodes.get(0).col;
        List<Integer> curr = new ArrayList<>();

        for (Pair p : nodes) {
            if (p.col != prevCol) {
                ans.add(curr);
                curr = new ArrayList<>();
                prevCol = p.col;
            }
            curr.add(p.node.val);
        }

        ans.add(curr);
        return ans;

    }
}