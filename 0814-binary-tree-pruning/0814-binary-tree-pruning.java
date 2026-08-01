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
    TreeNode root;
    private TreeNode dfs(TreeNode node)
     {
        if(node==null) return null;
        
        node.left=dfs(node.left);
        node.right=dfs(node.right);

        if(node.left==null&&node.right==null&&node.val!=1)
        {
            return null;
        }
        return node;
       

     }
    public TreeNode pruneTree(TreeNode node) {
        
        return dfs(node);
    }
}