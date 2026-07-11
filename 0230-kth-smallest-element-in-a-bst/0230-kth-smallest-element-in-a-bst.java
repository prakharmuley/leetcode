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
    public void dfs(TreeNode root, int cnt, int[] a, int k)
    {
        if(root==null) return;
        dfs(root.left,cnt,a,k); 
        a[1]++;
        if(a[1]==k)
        {
            a[0]=root.val;
            return;
        }
        dfs(root.right,cnt,a,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] a=new int[2];
        dfs(root,0,a,k);
        return a[0];

    }
}