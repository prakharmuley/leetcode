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
    List<Integer> list=new ArrayList<>();
    int cnt;
    public void dfs(TreeNode root, int idx)
    {
        if(root==null) return;
        list.add(idx);
        cnt++;
        dfs(root.left,2*idx+1);
        dfs(root.right,2*idx+2);

    }
    public boolean isCompleteTree(TreeNode root) {
        cnt=0;
        dfs(root,0);
        for(int x: list)
        {
            if(x>=cnt) return false;
        }
        return true;

    }
}