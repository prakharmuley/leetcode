class Solution {
    // private int fun(int[] arr, int t, int[] dp)
    // {
    //     if(t==0) return 1;
    //     if(t<0) return 0;
    //     if(dp[t]!=-1) return dp[t];
    //     int ans=0;
    //     for(int x: arr)
    //     {
    //         ans+=fun(arr,t-x,dp);
    //     }
    //     return dp[t]=ans;
    // }
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int[] dp=new int[target+1];
        Arrays.sort(nums);
        dp[0]=1;
        for(int i=1;i<=target;i++)
        {
            for(int x: nums)
            {
                if(i<x) break;
                dp[i]+=dp[i-x];
            }
        }
        // Arrays.fill(dp,-1);
        // return fun(nums,target,dp);
        return dp[target];
    }
}