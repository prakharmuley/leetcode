class Solution {
    // private int fun(int target, int[] dp)
    // {
    //    if(target==0) return 0;
    //    if(dp[target]!=-1) return dp[target];
    //    int ans=Integer.MAX_VALUE;
    //     for(int i=1;i*i<=target;i++)
    //     {
    //         ans=Math.min(ans,1+fun(target-i*i,dp));
    //     }
    //     return dp[target]=ans;
    // }
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=(int)Math.sqrt(i);j++)
            {
                  if(i-j*j>=0)
                  {
                      dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                  }
            }
        }
        return dp[n];
    }
}