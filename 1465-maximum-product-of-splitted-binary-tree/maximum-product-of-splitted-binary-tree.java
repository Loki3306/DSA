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
    long total=0;
    long max=0;

    public int maxProduct(TreeNode root) {
        total=totalSum(root);
        sol(root);
        return (int)(max%1000000007);
    }

    public int totalSum(TreeNode node){
        if(node == null) return 0;
        return node.val + totalSum(node.left) + totalSum(node.right);
    }

    public long sol(TreeNode root){
        if(root == null) return 0;
        long left=sol(root.left);
        long right=sol(root.right);
        long subSum= root.val +left+right;
        long prod=subSum * (total-subSum);
        if(prod > max) max=prod;
        return subSum;
    }
}