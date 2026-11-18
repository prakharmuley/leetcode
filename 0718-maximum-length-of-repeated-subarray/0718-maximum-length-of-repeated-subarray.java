class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums2.length;
        int n=nums1.length;
        int[] dp= new int[m+1];
        int max=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=m;j>=1;j--)
            {
                if(nums1[i-1]==nums2[j-1])
                {
                    dp[j]=dp[j-1]+1;
                    max=Math.max(max,dp[j]);
                }
                else dp[j]=0;
            }
        }
        return max;
    }
}