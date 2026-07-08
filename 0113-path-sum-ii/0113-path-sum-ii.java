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
    public void dfs(TreeNode root, int t, List<List<Integer>> list, List<Integer> l, int s)
    {
        if(root==null) return ;
        s+=root.val;
        l.add(root.val);
        if(root.left==null&&root.right==null)
        {
            if(s==t)
            {
                list.add(new ArrayList<>(l));
                l.remove(l.size()-1);
                s-=root.val;
                return;
            }
           
        }
        dfs(root.left,t,list,l,s);
        dfs(root.right,t,list,l,s);
        if(l.size()>0){
        l.remove(l.size()-1);
        s-=root.val;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        dfs(root,targetSum,list,l,0);
        return list;
    }
}