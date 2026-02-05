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

    int idx = 0;
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<preorder.length;i++){
            map.put(inorder[i],i);
        }    

        return construct(preorder,inorder,0,preorder.length-1);
    }

    public TreeNode construct(int[] preorder,int[] inorder,int s,int e){
        if(s > e) return null;

        TreeNode root = new TreeNode(preorder[idx]);
        idx++;

        int pos = map.get(root.val);

        root.left = construct(preorder,inorder,s,pos-1);
        root.right = construct(preorder,inorder,pos+1,e);

        return root;
    }

}