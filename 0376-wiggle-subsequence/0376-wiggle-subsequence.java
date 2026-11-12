class Solution {
    private int fun(int i, int n, int[] arr, Integer[][] dp, int sign) {
        if (dp[i][sign] != null) return dp[i][sign];
        
        int ans = 0;
        for (int j = i + 1; j < n; j++) {
            int diff = arr[j] - arr[i];
            if (sign == 0) {
                if (diff > 0) {
                    ans = Math.max(ans, 1 + fun(j, n, arr, dp, 2));
                } else if (diff < 0) {
                    ans = Math.max(ans, 1 + fun(j, n, arr, dp, 1));
                }
            } else if (sign == 1) { 
                if (diff > 0) {
                    ans = Math.max(ans, 1 + fun(j, n, arr, dp, 2));
                }
            } else { 
                if (diff < 0) {
                    ans = Math.max(ans, 1 + fun(j, n, arr, dp, 1));
                }
            }
        }
        return dp[i][sign] = ans;
    }

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Integer[][] dp = new Integer[n][3];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, 1 + fun(i, n, nums, dp, 0));
        }
        return max;
    }
}