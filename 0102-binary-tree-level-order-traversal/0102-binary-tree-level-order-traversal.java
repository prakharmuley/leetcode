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
    public void dfs(TreeNode root, List<List<Integer>> list, int depth)
    {
        if(root==null) return;
        if(list.size()==depth)
        {
            list.add(new ArrayList<>());
        }
        list.get(depth).add(root.val);
        dfs(root.left,list,depth+1);
        dfs(root.right,list,depth+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        dfs(root,list,0);
        return list;
        
    }
}