class Solution {

    private int maxSubarrayNoMoreThanK(int[] arr, int k) {

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int prefix = 0;
        int best = Integer.MIN_VALUE;

        for (int x : arr) {
            prefix += x;

            Integer prev = set.ceiling(prefix - k);
            if (prev != null) {
                best = Math.max(best, prefix - prev);
            }

            set.add(prefix);
        }

        return best;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int answer = Integer.MIN_VALUE;

        if (rows <= cols) {
            // Fix top and bottom rows
            int[] compressed = new int[cols];

            for (int top = 0; top < rows; top++) {
                Arrays.fill(compressed, 0);

                for (int bottom = top; bottom < rows; bottom++) {

                    for (int c = 0; c < cols; c++) {
                        compressed[c] += matrix[bottom][c];
                    }

                    answer = Math.max(
                        answer,
                        maxSubarrayNoMoreThanK(compressed, k)
                    );
                }
            }
        } else {
            // Fix left and right columns
            int[] compressed = new int[rows];

            for (int left = 0; left < cols; left++) {
                Arrays.fill(compressed, 0);

                for (int right = left; right < cols; right++) {

                    for (int r = 0; r < rows; r++) {
                        compressed[r] += matrix[r][right];
                    }

                    answer = Math.max(
                        answer,
                        maxSubarrayNoMoreThanK(compressed, k)
                    );
                }
            }
        }

        return answer;
    }
}