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
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int left = leftHeight(root);
        int right = rightHeight(root);

        if(left == right) return (1 << left) -1 ;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int leftHeight(TreeNode node){
        int cnt = 0;

        while(node != null){
            cnt++;
            node = node.left;
        }
        
        return cnt;
    }

    public int rightHeight(TreeNode node){
        int cnt = 0;

        while(node != null){
            cnt++;
            node = node.right;
        }
        
        return cnt;
    }
}