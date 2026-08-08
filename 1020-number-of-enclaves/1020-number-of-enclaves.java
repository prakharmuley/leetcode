class Solution {
    public void dfs(int i, int j, int[][] arr, int n, int m, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= n || j >= m || arr[i][j] == 0 || vis[i][j])
            return;

        vis[i][j] = true;

        dfs(i + 1, j, arr, n, m, vis);
        dfs(i - 1, j, arr, n, m, vis);
        dfs(i, j + 1, arr, n, m, vis);
        dfs(i, j - 1, arr, n, m, vis);
    }

    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 1)
                dfs(0, j, board, n, m, vis);

            if (board[n - 1][j] == 1)
                dfs(n - 1, j, board, n, m, vis);
        }

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 1)
                dfs(i, 0, board, n, m, vis);

            if (board[i][m - 1] == 1)
                dfs(i, m - 1, board, n, m, vis);
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 1 && !vis[i][j])
                    cnt++;
            }
        }

        return cnt;
    }
}