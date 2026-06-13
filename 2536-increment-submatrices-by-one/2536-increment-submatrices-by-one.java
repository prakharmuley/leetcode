class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans=new int[n][n];
        for(int[] q: queries)
        {
            int r1=q[0];
            int c1=q[1];
            int r2=q[2];
            int c2=q[3];
            for(int i=r1;i<=r2;i++)
            {
                ans[i][c1]+=1;
                if(c2+1<n)
                {
                    ans[i][c2+1]-=1;
                }
            }
           
        }
         for(int i=0;i<n;i++)
            {
                for(int j=1;j<n;j++)
                {
                    ans[i][j]+=ans[i][j-1];
                }
            }
            return ans;
    }
}