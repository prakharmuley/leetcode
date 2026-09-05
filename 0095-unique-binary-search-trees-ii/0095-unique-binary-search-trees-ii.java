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
    
    public List<TreeNode> dfs(int st, int end)
    {
        List<TreeNode> list=new ArrayList<>();
        if(st>end) 
        {
            list.add(null);
            return list;
        }
        for(int mid=st;mid<=end;mid++){
        List<TreeNode> left=dfs(st,mid-1);
        List<TreeNode> right=dfs(mid+1,end);
        for(TreeNode x: left)
        {
            for(TreeNode y: right)
            {
                TreeNode root=new TreeNode(mid);
                root.left=x;
                root.right=y;
                list.add(root);
            }
        } 
      }       
        return list;
    }
    public List<TreeNode> generateTrees(int n) {
            
        return dfs(1,n);
    
     
    }
}