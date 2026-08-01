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
    int h1;
    int h2;
    TreeNode p1=null;
    TreeNode p2=null;
    public void dfs(TreeNode root, TreeNode par, int h, int val, int f)
    {
        if(root==null) return ;
        if(root.val==val)
        {
           if(f==1){
            h1=h;
            p1=par;
           }
           else {h2=h; p2=par;}

            return;
        }
        dfs(root.left,root,h+1,val,f);
        dfs(root.right,root,h+1,val,f);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,1,x,0);
        dfs(root,null,1,y,1);
        return h1==h2&&p1!=p2;
    }
}