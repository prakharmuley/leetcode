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
    Map<Long, Integer> mp;
    int ans=0;
    public void dfs(TreeNode root, int t, long cur)
    {
        if(root==null) return;
        cur+=root.val;
        ans+=mp.getOrDefault(cur-t,0);
        mp.put(cur,mp.getOrDefault(cur,0)+1);
        dfs(root.left,t,cur);
        dfs(root.right,t,cur);
        mp.put(cur,mp.get(cur)-1);
        if(mp.get(cur)==0) mp.remove(cur);

    }
    public int pathSum(TreeNode root, int targetSum) {
        mp=new HashMap<>();
        mp.put(0L,1);
        dfs(root,targetSum,0);
        return ans;
        
    }
}