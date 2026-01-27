import java.util.*;

class Pair {
    TreeNode node;
    int row;
    int col;

    Pair(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0, 0));

        List<Pair> list = new ArrayList<>();

        while (!q.isEmpty()) {
            Pair p = q.poll();
            list.add(p);

            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;

            if (node.left != null)
                q.offer(new Pair(node.left, row + 1, col - 1));
            if (node.right != null)
                q.offer(new Pair(node.right, row + 1, col + 1));
        }

        Collections.sort(list, (a, b) -> {
            if (a.col != b.col)
                return a.col - b.col;
            if (a.row != b.row)
                return a.row - b.row;
            return a.node.val - b.node.val;
        });

        int prevCol = Integer.MIN_VALUE;
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            Pair p = list.get(i);

            if (p.col != prevCol) {
                if (temp.size() != 0) {
                    ans.add(temp);
                }
                temp = new ArrayList<>();
                prevCol = p.col;
            }

            temp.add(p.node.val);
        }

        if (temp.size() != 0) {
            ans.add(temp);
        }
        return ans;
    }
}
