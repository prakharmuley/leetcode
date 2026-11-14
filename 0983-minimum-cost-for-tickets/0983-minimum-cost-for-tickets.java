class Solution {
   public int fun(int[] a, int i, int[] c, int[] dp, int n)
   {
    if(i>=n) return 0;
    if(dp[i]!=-1) return dp[i];
    int c1=c[0]+fun(a,i+1,c,dp,n);
    int j=i;
    int mx=a[i]+7;
    while(j<n&&a[j]<mx) j++;
    int c7=c[1]+fun(a,j,c,dp,n);

    j=i;
    mx=a[i]+30;
    while(j<n&&a[j]<mx) j++;
    int c30=c[2]+fun(a,j,c,dp,n);
    return dp[i]=Math.min(c1,Math.min(c7,c30)); 
   }
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return fun(days,0,costs,dp,n);
    }
}