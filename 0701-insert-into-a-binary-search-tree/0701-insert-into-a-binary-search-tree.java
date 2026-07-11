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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node=root;
        if(root==null)
        {
            return new TreeNode(val);
        }
        while(root!=null)
        {
            if(root.val>val)
            {
                if(root.left==null)
                {
                    root.left=new TreeNode(val);
                    break;
                }
                root=root.left;
                
               
            }
            else
            {
                if(root.right==null)
                {
                    root.right=new TreeNode(val);
                    break;
                }
                root=root.right;
            }

        }
        return node;
    }
}