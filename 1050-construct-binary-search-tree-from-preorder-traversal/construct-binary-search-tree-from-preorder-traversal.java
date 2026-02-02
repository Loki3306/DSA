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
    public static int idx = 0;


    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return construct(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode construct(int[] pre,int min,int max){
        if(idx >= pre.length) return null;

        int key = pre[idx];
        if(key <= min || key >=max) return null;

        TreeNode node = new TreeNode(key);
        idx ++;

        node.left = construct(pre,min,key);
        node.right = construct(pre,key,max);

        return node;
    }
}