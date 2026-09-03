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
    
    private TreeNode dfs(int[] in, int in_st, int in_end, int[] pre, int pre_st, int pre_end, Map<Integer,Integer> mp)
    {
         if(in_st>in_end||pre_st>pre_end) return null;
         int idx=mp.get(pre[pre_st]);
         TreeNode root=new TreeNode(pre[pre_st]);
         int dist=idx-in_st;
         root.left=dfs(in,in_st,idx-1,pre,pre_st+1,pre_st+dist,mp);
         root.right=dfs(in,idx+1,in_end,pre,pre_st+dist+1,pre_end,mp);
         return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++) mp.put(inorder[i],i);
        return dfs(inorder,0,n-1,preorder,0,n-1, mp);
        
    }
}