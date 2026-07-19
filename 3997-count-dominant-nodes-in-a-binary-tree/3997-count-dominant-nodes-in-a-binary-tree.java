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
    public int dfs(TreeNode root, int[] a, int mx)
    {
        if(root==null) return 0;
        if(root.left==null&&root.right==null)
        {
               a[0]++;
               return root.val;
        }
        mx=Math.max(root.val,mx);
        int l=dfs(root.left,a,mx);
        int r=dfs(root.right,a,mx);
        if(root.val>=Math.max(l,r)) 
        {
            a[0]++;
        }
        return Math.max(root.val,Math.max(l,r));
    }
    public int countDominantNodes(TreeNode root) {
        int[] arr=new int[1];
        dfs(root,arr,0);
        return arr[0];
    }
}