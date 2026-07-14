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

    long ans = 0;
    List<Long> firstIndex = new ArrayList<>();

    public int widthOfBinaryTree(TreeNode root) {

        dfs(root, 0, 1L);

        return (int) ans;
    }

    private void dfs(TreeNode root, int level, long index) {

        if (root == null)
            return;

        if (level == firstIndex.size())
            firstIndex.add(index);

        ans = Math.max(ans, index - firstIndex.get(level) + 1);

        dfs(root.left, level + 1, index * 2);

        dfs(root.right, level + 1, index * 2 + 1);
    }
}