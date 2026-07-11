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
    public void dfs(TreeNode root, TreeNode node, int val)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null)
        {
            if(root.val>val)
            {
                root.left=new TreeNode(val);
                return;
            }    
        }
         if(root.right==null)
        {
          if(root.val<val)
            {
                root.right=new TreeNode(val);
                return;
            }
        }

        if(root.val<val)
          dfs(root.right, node,val);

        if(root.val>val)
          dfs(root.left, node,val);
       
        
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node=root;
        if(root==null) return new TreeNode(val);
        dfs(root,node,val);
        return root;
    }
}