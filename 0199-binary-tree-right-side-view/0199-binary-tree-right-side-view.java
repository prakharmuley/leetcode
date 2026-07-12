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
    public void dfs(int depth, TreeNode root, TreeMap<Integer,Integer> mp, List<Integer> list)
    {
        if(root==null) return;
        if(list.size()==depth) {
        list.add(root.val);
        }
        dfs(depth+1,root.right,mp,list);
        dfs(depth+1,root.left,mp,list);
    }
    public List<Integer> rightSideView(TreeNode root) {
        TreeMap<Integer,Integer> mp=new TreeMap<>();
        List<Integer> list=new ArrayList<>();
        dfs(0,root,mp,list);
        
        return list;
        
    }
}