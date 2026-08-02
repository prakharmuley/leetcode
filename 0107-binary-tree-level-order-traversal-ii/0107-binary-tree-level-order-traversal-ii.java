class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        if (depth == ans.size()) {
            ans.add(0, new ArrayList<>());
        }

        ans.get(ans.size() - depth - 1).add(root.val);

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
}