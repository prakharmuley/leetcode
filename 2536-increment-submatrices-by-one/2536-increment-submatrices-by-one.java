class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans=new int[n][n];
        // for(int[] q: queries)
        // {
        //     int r1=q[0];
        //     int c1=q[1];
        //     int r2=q[2];
        //     int c2=q[3];
        //     for(int i=r1;i<=r2;i++)
        //     {
        //         ans[i][c1]+=1;
        //         if(c2+1<n)
        //         {
        //             ans[i][c2+1]-=1;
        //         }
        //     }
           
        // }
        //  for(int i=0;i<n;i++)
        //     {
        //         for(int j=1;j<n;j++)
        //         {
        //             ans[i][j]+=ans[i][j-1];
        //         }
        //     }
        //     return ans;

        //More optimization now
        int[][] d=new int[n+1][n+1];
         for(int[] q: queries)
        {
            int r1=q[0];
            int c1=q[1];
            int r2=q[2];
            int c2=q[3];
            d[r1][c1]++;
            d[r1][c2+1]--;
            d[r2+1][c1]--;
            d[r2+1][c2+1]++;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int top=0,left=0,cmn=0;
                if(i>0)
                {
                    top=ans[i-1][j];
                }
                if(j>0)
                {
                  left=ans[i][j-1];
                }
                if(i>0&&j>0)
                {
                  cmn=ans[i-1][j-1];
                }
                ans[i][j]=d[i][j]+top+left-cmn;

            }
        }
        return ans;






    }
}