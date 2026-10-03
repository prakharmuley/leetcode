class Solution {

    private boolean isSafe(char[][] arr, int row, int col, int n) {

        for (int j = 0; j < n; j++) {
            if (arr[row][j] == 'Q') return false;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i][col] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 'Q') return false;
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (arr[i][j] == 'Q') return false;
        }

        return true;
    }

    private void dfs(int row, char[][] arr, int n, List<List<String>> ans) {

        if (row == n) {
            List<String> l = new ArrayList<>();

            for (char[] c : arr) {
                l.add(new String(c));
            }

            ans.add(l);
            return;
        }

        for (int j = 0; j < n; j++) {

            if (isSafe(arr, row, j, n)) {

                arr[row][j] = 'Q';

                dfs(row + 1, arr, n, ans);

                arr[row][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] arr = new char[n][n];

        for (char[] c : arr) {
            Arrays.fill(c, '.');
        }

        dfs(0, arr, n, ans);

        return ans;
    }
}