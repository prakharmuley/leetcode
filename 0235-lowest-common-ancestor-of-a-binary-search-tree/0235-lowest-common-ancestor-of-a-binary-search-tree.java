/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans=null;;
    public void dfs(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null) return ;
        ans=root;
        if((p.val<root.val&&q.val>root.val)||(p.val>root.val&&q.val<root.val))
        {
           return;
        }
        if(p.val>root.val&&q.val>root.val)
        {
             dfs(root.right,p,q);
        }
        if(p.val<root.val&&q.val<root.val)
        {
             dfs(root.left,p,q);
        }
        

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(p.val>q.val)
        // {
        //     int temp=p.val;
        //     p.val=q.val;
        //     q.val=temp;   
        // }
        ans=root;
        dfs(root,p,q);
        return ans;
    }
}