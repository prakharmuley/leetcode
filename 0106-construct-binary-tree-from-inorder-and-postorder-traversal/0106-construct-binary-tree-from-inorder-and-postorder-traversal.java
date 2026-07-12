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
    public TreeNode build(int is, int ie, int[] in, int ps, int pe, int[] post, Map<Integer,Integer> mp)
    {
        if(ps>pe) return null;
        int idx=mp.get(post[pe]);
        int sz=idx-is;
        TreeNode root=new TreeNode(post[pe]);
        root.left=build(is,idx-1,in,ps,ps+sz-1,post,mp);
        root.right=build(idx+1,ie,in,ps+sz,pe-1,post,mp);
        return root;

    }
    public TreeNode buildTree(int[] in, int[] post) {
        Map<Integer,Integer> mp=new HashMap<>();
        int n=in.length;
        for(int i=0;i<n;i++) mp.put(in[i],i);
        return build(0,n-1,in,0,n-1,post,mp); 
    }
}