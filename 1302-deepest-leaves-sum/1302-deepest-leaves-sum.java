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
    private void fun(TreeNode root, int height, int h)
    {
        if(root==null) return;
        if(root.left==null&&root.right==null) {
            if(height-1==h)
             ans+=root.val; 

             return;
        }
        fun(root.left,height,h+1);
        fun(root.right,height,h+1);

    }
    private int findDepth(TreeNode root)
    {
        if(root==null) return 0;
        int l=findDepth(root.left);
        int r=findDepth(root.right);
        return 1+Math.max(l,r);
    }
    public int deepestLeavesSum(TreeNode root) {
        int h=findDepth(root);
        ans=0;
        fun(root,h,0);
        return ans;
        
    }
}