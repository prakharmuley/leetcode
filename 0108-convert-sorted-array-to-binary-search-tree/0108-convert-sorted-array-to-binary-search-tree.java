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

    public TreeNode fun(int[] nums, int l, int r)
    {
        if(l>r) return null;
        int mid=(l+r)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=fun(nums,l,mid-1);
        root.right=fun(nums,mid+1,r);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        
        int n=nums.length;
        int l=0,r=n;
        return fun(nums,l,r-1);
        
        
    }
}