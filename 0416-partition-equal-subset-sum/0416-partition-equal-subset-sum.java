import java.util.Arrays;

class Solution {
    private boolean fun(int[] arr, Boolean[][] dp, int n, int t) {
        if (t == 0) return true;
        if (n < 0 || t < 0) return false;
        
        if (dp[n][t] != null) return dp[n][t];
        
        boolean include = false;
        if (t >= arr[n]) {
            include = fun(arr, dp, n - 1, t - arr[n]);
        }
        boolean exclude = fun(arr, dp, n - 1, t);
        
        return dp[n][t] = (include || exclude);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) sum += x;
            if (sum % 2 != 1) {
            sum >>= 1; 
            int n = nums.length;
            Boolean[][] dp = new Boolean[n][sum + 1];
            return fun(nums, dp, n - 1, sum);
        }
        return false;
    }
}