class Solution {
    // private int solve(int[] nums, int i, Integer[] dp) {
    //     if (i >= nums.length) return 0;
    //     if (dp[i] != null) return dp[i];
        
    //     int nextMax = solve(nums, i + 1, dp);
    //     dp[i] = nums[i] + Math.max(0, nextMax);
    //     return dp[i];
    // }

    // public int maxSubArray(int[] nums) {
    //     Integer[] dp = new Integer[nums.length];
    //     int maxSum = Integer.MIN_VALUE;
        
    //     for (int i = 0; i < nums.length; i++) {
    //         maxSum = Math.max(maxSum, solve(nums, i, dp));
    //     }
        
    //     return maxSum;
    // }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        
        int[] dp = new int[n];
        dp[0] = nums[0]; // Base case
        int maxSum = dp[0];
        
        // Loop from left to right (0 to n-1)
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, dp[i]); // Track the global max
        }
        
        return maxSum;
    }

}
