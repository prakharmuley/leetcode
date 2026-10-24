class Solution {

    private int memo(int []dp, int[] arr, int n, int i)
    {
         if(i>=n) return 0;
         if(dp[i]!=-1) return dp[i];
         int take=arr[i]+memo(dp,arr,n,i+2);
         int not_take=memo(dp,arr,n,i+1);
         return dp[i]=Math.max(take,not_take);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int l = memo(dp, Arrays.copyOfRange(nums, 0, n - 1), n - 1, 0);
        
        Arrays.fill(dp, -1);
        int r = memo(dp, Arrays.copyOfRange(nums, 1, n), n - 1, 0);
        
        return Math.max(l, r);
    }
}