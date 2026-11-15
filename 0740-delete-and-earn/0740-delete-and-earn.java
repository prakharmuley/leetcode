// class Solution {
//     private int fun(int i, int n, int[] arr, int[] dp, int[] freq)
//     {
//         if(i>=n||i<0) return 0;
//         if(dp[i]!=-1) return dp[i];
//         int res=0;
//         int j=i;
//         res=arr[i]*freq[arr[i]];
//         while(j<n&&arr[j]<=arr[i]+1) j++;
//         int tk=res+fun(j,n,arr,dp,freq);
//         int nxt=i;

//         while(nxt<n&&arr[nxt]==arr[i]) nxt++;
//         int skip=fun(nxt,n,arr,dp,freq);
        
//         return dp[i]=Math.max(tk,skip);

//     }
//     public int deleteAndEarn(int[] nums) {
//         int n=nums.length;
//         Arrays.sort(nums);
//         int[] dp=new int[n];
//         Arrays.fill(dp,-1);
//         int[] freq=new int[20001];
//         int ans=Integer.MAX_VALUE;
//         for(int x: nums) freq[x]++;
        
//          return fun(0,n,nums,dp,freq);
        
//     }
// }
class Solution {
    
    public int deleteAndEarn(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int[] dp=new int[n+1];
        int[] freq=new int[20001];
        int ans=Integer.MAX_VALUE;
        for(int x: arr) freq[x]++;
         for(int i=n-1;i>=0;i--)
        {
            int val=arr[i]*freq[arr[i]];
            int j=i;
            while(j<n&&arr[j]<=arr[i]+1)
               j++;
            int tk=val+dp[j];
            int nxt=i;
            while(nxt<n&&arr[nxt]==arr[i]) nxt++;
            int skip=dp[nxt];
            dp[i]=Math.max(tk,skip);
        }
        return dp[0];
        
        
    }
}