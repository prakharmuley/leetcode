class Solution {

    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int dfs(int i, int j, int id, int[][] grid) {

        if (i < 0 || j < 0 || i >= n || j >= m ||
            grid[i][j] != 1)
            return 0;

        grid[i][j] = id;

        int size = 1;

        for (int k = 0; k < 4; k++) {
            size += dfs(i + dr[k], j + dc[k], id, grid);
        }

        return size;
    }

    public int largestIsland(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        // island ID -> island size
        Map<Integer, Integer> map = new HashMap<>();

        int id = 2;

        // Step 1: Label every island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {

                    int size = dfs(i, j, id, grid);

                    map.put(id, size);

                    id++;
                }
            }
        }

        int ans = 0;

        // Step 2: Try flipping every 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0) {

                    Set<Integer> set = new HashSet<>();

                    int size = 1;

                    for (int k = 0; k < 4; k++) {

                        int ni = i + dr[k];
                        int nj = j + dc[k];

                        if (ni >= 0 && nj >= 0 &&
                            ni < n && nj < m &&
                            grid[ni][nj] != 0) {

                            int islandId = grid[ni][nj];

                            if (set.add(islandId)) {
                                size += map.get(islandId);
                            }
                        }
                    }

                    ans = Math.max(ans, size);
                }
            }
        }

        // All 1s case
        return ans == 0 ? n * m : ans;
    }
}