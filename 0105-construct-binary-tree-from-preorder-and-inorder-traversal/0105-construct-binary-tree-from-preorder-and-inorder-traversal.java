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
    int n;
    public  TreeNode build(int in_st,int in_end,int[] in, int pre_st,int pre_end, int[] pre, Map<Integer,Integer> mp)
    {
      if(pre_st>pre_end) return null;
      int idx=mp.get(pre[pre_st]);
      int lsz=idx-in_st;
      TreeNode root=new TreeNode(pre[pre_st]);
      root.left=build(in_st,idx-1,in, pre_st+1, pre_st+lsz, pre,mp);
      root.right=build(idx+1,in_end,in,pre_st+lsz+1,pre_end,pre,mp);
      return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mp=new HashMap<>();
        this.n=inorder.length;
        for(int i=0;i<n;i++)
        {
            mp.put(inorder[i],i);
        }
        return build(0,n-1,inorder,0,n-1,preorder,mp);
    }
}