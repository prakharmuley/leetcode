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
    public int dfs(TreeNode root, int[] arr)
    {
        if(root==null) return 0;
        int l=Math.max(0,dfs(root.left,arr));
        if(l==0) arr[0]=Math.max(arr[0],root.val);
        int r=Math.max(0,dfs(root.right,arr));
        if(r==0) arr[0]=Math.max(arr[0],root.val);
        arr[0]=Math.max(arr[0],l+r+root.val);
        return root.val+Math.max(l,r);
    }
    public int maxPathSum(TreeNode root) {
        int[] ans=new int[1];
        ans[0]=Integer.MIN_VALUE;
        dfs(root,ans);
        return ans[0];
    }
}