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
    public int dfs(TreeNode root, int[] a)
    {
        if(root==null) return 0;
        int l=dfs(root.left,a);
        int r=dfs(root.right,a);
        a[0]=Math.max(a[0],l+r);
        return 1+Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans=new int[1];
        dfs(root,ans);
        return ans[0];
    }
}