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
    public int dfs(TreeNode root, int[] ans)
    {
        if(root==null) return 0;
        int l=Math.max(dfs(root.left,ans),0);
        int r=Math.max(dfs(root.right,ans),0);
        ans[0]=Math.max(ans[0],root.val+l+r);
        return root.val+Math.max(l,r);
    }
    public int maxPathSum(TreeNode root) {
        int[] ans=new int[1];
        ans[0]=Integer.MIN_VALUE;
        dfs(root,ans);
        return ans[0];
    }
}