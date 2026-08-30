class Solution {

    public void dfs(int i, int j, int n, int m, int[][] arr, int[] a) {
        if (i < 0 || j < 0 || i >= n || j >= m || arr[i][j] == 0)
            return;

        a[0]++;
        arr[i][j] = 0;

        dfs(i + 1, j, n, m, arr, a);
        dfs(i - 1, j, n, m, arr, a);
        dfs(i, j + 1, n, m, arr, a);
        dfs(i, j - 1, n, m, arr, a);
    }

    public int countIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int[] a = new int[1];
                    dfs(i, j, n, m, grid, a);
                    count++;
                }
            }
        }

        return count;
    }

    public int minDays(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // Count initial islands
        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            copy[i] = grid[i].clone();
        }

        int islands = countIslands(copy);

        // Already disconnected or no land
        if (islands != 1)
            return 0;

        // Try removing one cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {

                    grid[i][j] = 0;

                    int[][] temp = new int[n][m];

                    for (int x = 0; x < n; x++) {
                        temp[x] = grid[x].clone();
                    }

                    if (countIslands(temp) != 1)
                        return 1;

                    // Restore
                     grid[i][j] = 1;
                }
            }
        }

        // If no single cell works, two cells are always enough
        return 2;
    }
}