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
    public int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder,inorder,0,preorder.length - 1);    
    }

    public TreeNode construct(int[] preorder,int[] inorder,int s,int e){
        if(s > e) return null;

        TreeNode root = new TreeNode(preorder[index]);
        index++;

        int position = findIndex(inorder,root.val,s,e);

        root.left = construct(preorder,inorder,s,position-1);
        root.right = construct(preorder,inorder,position+1,e);

        return root;
    }

    public int findIndex(int[] arr,int key,int s,int e){
        for(int i=s;i<=e;i++){
            if(arr[i] == key) return i;
        }
        return -1;
    }
}