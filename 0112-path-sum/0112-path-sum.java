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
    public boolean dfs(TreeNode root, int[] a, int t)
    {
        if(root==null)
        {
            return false;
        }
        a[0]+=root.val;
        if(root.left==null&&root.right==null)
        {
          if(a[0]==t) return true;

          
        }
      
        boolean l=false,r=false;
        if(root.left!=null)
        {
           l=dfs(root.left,a,t);
        }
        if(root.right!=null)
        {
           r=dfs(root.right,a,t);
        }
        a[0]-=root.val;
        return l||r;


    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int[] a=new int[1];
        return dfs(root,a,targetSum);
    }
}