class Solution {
    private int solve(int[] nums, int i, Integer[] dp) {
        if (i >= nums.length) return 0;
        if (dp[i] != null) return dp[i];
        
        int nextMax = solve(nums, i + 1, dp);
        dp[i] = nums[i] + Math.max(0, nextMax);
        return dp[i];
    }

    public int maxSubArray(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(maxSum, solve(nums, i, dp));
        }
        
        return maxSum;
    }
}