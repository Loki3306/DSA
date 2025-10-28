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
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list=new ArrayList<>();
        if(node == null) return list;
        Stack<TreeNode> stack=new Stack<>();

        stack.push(node);

        while(!stack.isEmpty()){
            TreeNode root=stack.pop();
            list.add(root.val);

            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }

        return list;
    }
}