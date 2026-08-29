class Solution {
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 2 * m * n);
        }

        dist[0][0] = 0;

        int[] dir = {-1, 0, 1, 0, -1};

        int ans = 0;

        while (!q.isEmpty()) {
            int l = q.size();

            for (int j = 0; j < l; j++) {
                int[] p = q.poll();

                int x = p[0];
                int y = p[1];
                int cnt = p[2];

                if (x == n - 1 && y == m - 1) {
                    return ans;
                }

                for (int i = 0; i < 4; i++) {
                    int r = x + dir[i];
                    int c = y + dir[i + 1];

                    if (r < 0 || c < 0 || r >= n || c >= m) {
                        continue;
                    }

                    int newCnt = cnt + grid[r][c];

                    if (newCnt > k || newCnt >= dist[r][c]) {
                        continue;
                    }

                    dist[r][c] = newCnt;
                    q.offer(new int[]{r, c, newCnt});
                }
            }

            ans++;
        }

        return -1;
    }
}