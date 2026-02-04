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

class Pair{
    TreeNode node;
    long idx;

    public Pair(TreeNode node,long idx){
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        long maxWidth = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            int size = q.size();
            long first = q.peek().idx;
            long last = first;

            for(int i=0;i<size;i++){
                Pair p = q.poll();
                TreeNode node = p.node;
                long idx = p.idx;
                last = idx;

                if(node.left != null) q.offer(new Pair(node.left, 2*idx +1));
                if(node.right != null) q.offer(new Pair(node.right, 2*idx +2));
            }

            maxWidth = Math.max(maxWidth, last-first+1);
        }

        return (int)maxWidth;
    }
}