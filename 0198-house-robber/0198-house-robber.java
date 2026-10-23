class Solution {
    // private int memo(int []dp, int[] arr, int n, int i)
    // {
    //      if(i>=n) return 0;
    //      if(dp[i]!=-1) return dp[i];
    //      int take=arr[i]+memo(dp,arr,n,i+2);
    //      int not_take=memo(dp,arr,n,i+1);
    //      return dp[i]=Math.max(take,not_take);
    // }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        if(n==1) return nums[0];
        // dp[0]=nums[0];
        // dp[1]=Math.max(nums[0],nums[1]);
        // for(int i=2;i<n;i++)
        // {
        //  dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);     
        // }
        int prev2=nums[0];
        int prev1=Math.max(nums[1],nums[0]);
        for(int i=2;i<n;i++)
        {
            int cur=Math.max(prev2+nums[i],prev1);
            prev2=prev1;
            prev1=cur;

        }
        return prev1;
    }
}