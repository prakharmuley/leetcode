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
    int ans;
    private void dfs(List<Integer> list, TreeNode root, int d, int cnt)
    {
         if(root==null) return;
         if(list.size()==d)
         {
             list.add(cnt);
         }
         ans=Math.max(ans,cnt-list.get(d)+1);
         dfs(list,root.left,d+1,2*cnt);
         dfs(list,root.right,d+1,2*cnt+1);

    }
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        ans=0;
        dfs(list,root,0,0);
        return ans;
    }
}