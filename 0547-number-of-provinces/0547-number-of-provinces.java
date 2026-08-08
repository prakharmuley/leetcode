class Solution {

    public void dfs(int node, int[][] arr, int n, boolean[] vis) {

        if (vis[node]) return;

        vis[node] = true;

        for (int j = 0; j < n; j++) {
            if (arr[node][j] == 1 && !vis[j]) {
                dfs(j, arr, n, vis);
            }
        }
    }

    public int findCircleNum(int[][] grid) {

        int n = grid.length;

        boolean[] vis = new boolean[n];

        int cnt = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                dfs(i, grid, n, vis);

                cnt++;
            }
        }

        return cnt;
    }
}