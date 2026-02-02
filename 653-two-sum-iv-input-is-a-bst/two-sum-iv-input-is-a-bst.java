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
    public boolean findTarget(TreeNode root, int k) {
       TreeNode curr = root;
       HashSet<Integer> set = new HashSet<>();

       return traverse(curr,set,k); 
    }

    public boolean traverse(TreeNode node,HashSet<Integer> set,int target){
        if(node == null) return false;

        if(set.contains(target - node.val)) return true;

        set.add(node.val);

        if(traverse(node.left,set,target) ) return true;
        if(traverse(node.right,set,target) ) return true;

        return false;
    }


}