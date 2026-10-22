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
        int n=nums.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return memo(dp,nums,n,0);
    }
}