class Solution {
    private boolean fun(int i, int n, int[] arr, Boolean[] dp)
    {
        if(i>=n-1) return true;
        if(arr[i]==0) return false;
        if(dp[i]!=null) return dp[i];
        for(int j=1;j<=arr[i];j++){
         if(fun(j+i,n,arr,dp))
          {
            return dp[j+i]=true;
          }
        }
    
        return dp[i]=false;
    }
    public boolean canJump(int[] nums) {
        Boolean[] dp=new Boolean[nums.length];
        if(fun(0,nums.length,nums,dp)) return true;
        
        return false;
    }
}