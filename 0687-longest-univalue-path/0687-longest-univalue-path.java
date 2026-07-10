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
        int l= dfs(root.left,ans);
        int r= dfs(root.right,ans);
        int lh=0,rh=0;
        if(root.left!=null)
        {
            if(root.val==root.left.val)
              lh=l+1;
        }
        if(root.right!=null)
        {
            if(root.val==root.right.val)
                rh=r+1;
        }
        ans[0]=Math.max(ans[0],lh+rh);

        return Math.max(lh,rh);

    

    }
    public int longestUnivaluePath(TreeNode root) {
        int[] ans=new int[1];
        dfs(root,ans);
        return ans[0];
    }
}