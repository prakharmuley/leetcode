class Solution {
     private int funn(int i, int n, int[] dp,int[] lendp, int[] arr, int max)
    {
        if(max==1) return dp[i]=1;
        if(lendp[i]!=-1) return lendp[i];
        int ways=0;
        for(int j=i+1;j<n;j++)
        {
            if(arr[i]<arr[j]&&dp[j]==max-1)
            {
               ways=ways+funn(j,n,dp,lendp,arr,max-1);
            }
        }
        return lendp[i]=ways;
        
    }

    private int fun(int i, int n, int[] dp, int[] arr)
    {
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
    public int findNumberOfLIS(int[] nums) {
         int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,fun(i,n,dp,nums));
        }
        int[] lendp=new int[n];
        Arrays.fill(lendp,-1);
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(dp[i]==ans)
             count+=funn(i,n,dp,lendp,nums,ans);
        }
        
        return count;
    }
}