class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1]
                          + mat[i - 1][j - 1];
            }
        }

        int ans = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= ans + 1 && j >= ans + 1) {
                    int r1 = i - ans - 1;
                    int c1 = j - ans - 1;
                    int sum = pre[i][j]
                            - pre[r1][j]
                            - pre[i][c1]
                            + pre[r1][c1];

                    if (sum <= threshold) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}

