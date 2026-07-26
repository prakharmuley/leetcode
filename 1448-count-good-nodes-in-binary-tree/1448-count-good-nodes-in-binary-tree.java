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
    int ans;
    private void dfs(TreeNode root, int mx)
    {
        if(root==null) return;
        if(mx<=root.val)
        {
            ans++;
        }
        mx=Math.max(mx,root.val);
        dfs(root.left,mx);
        dfs(root.right,mx);
    }
    public int goodNodes(TreeNode root) {
       int mx=root.val;
        ans=0;
        dfs(root,mx);
        return ans;
    }
}