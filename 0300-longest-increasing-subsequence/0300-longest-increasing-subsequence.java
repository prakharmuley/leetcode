class Solution {
    private int fun(int i, int n, int[] dp, int[] arr)
    {
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int ans=1;
        for(int j=i+1;j<n;j++)
        {
            if(arr[i]<arr[j])
            {
               ans=Math.max(ans,1+fun(j,n,dp,arr));   
            }
        }
        return dp[i]=ans;
    }
    public int lengthOfLIS(int[] nums) {
         int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,fun(i,n,dp,nums));
        }
        return ans;
    }
}