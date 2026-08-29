// 



class Solution {

    int[] dir = {-1, 0, 1, 0, -1};

    void dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;

        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean found = false;

        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    found = true;
                    break;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dir[d];
                    int ny = y + dir[d + 1];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || vis[nx][ny]) {
                        continue;
                    }

                    if (grid[nx][ny] == 1) {
                        return steps;
                    }

                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }

            steps++;
        }

        return -1;
    }
}