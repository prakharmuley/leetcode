class Solution {
    public int lcs(int n, int m, int[][] dp, int[] a1, int[] a2, int[] l)
    {
        if(n<=0||m<=0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        int a=0,b=0,c=0;
        if(a1[n-1]==a2[m-1])
        {
            a=1+lcs(n-1,m-1,dp,a1,a2,l);
        }
        b=lcs(n-1,m,dp,a1,a2,l);
        c=lcs(n,m-1,dp,a1,a2,l);
        l[0]=Math.max(l[0],a);
        return dp[n][m]=a;
    }
    public int findLength(int[] nums1, int[] nums2) {
        
       int l1=0,l2=0,r1=nums1.length-1,r2=nums2.length-1;
        int dp[][]=new int[nums1.length+1][nums2.length+1];
        int l[]=new int[1];
     
        for(int i=0;i<=nums1.length;i++)
            Arrays.fill(dp[i],-1);
      lcs(nums1.length,nums2.length,dp,nums1,nums2,l);
       
       return l[0]; 
    }
}