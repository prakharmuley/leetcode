class Solution {

    List<Long> sum = new ArrayList<>();
    List<Integer> cnt = new ArrayList<>();

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        if (depth == sum.size()) {
            sum.add((long) root.val);
            cnt.add(1);
        } else {
            sum.set(depth, sum.get(depth) + root.val);
            cnt.set(depth, cnt.get(depth) + 1);
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);

        List<Double> ans = new ArrayList<>();

        for (int i = 0; i < sum.size(); i++) {
            ans.add((double) sum.get(i) / cnt.get(i));
        }

        return ans;
    }
}