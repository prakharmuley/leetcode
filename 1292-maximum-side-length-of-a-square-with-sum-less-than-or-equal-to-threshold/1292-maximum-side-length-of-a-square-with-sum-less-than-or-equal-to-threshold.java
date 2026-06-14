class Solution {
    public boolean isValid(int sr, int sc, int size, int[][] row, int[][] col, int[][] arr, int t)
    {
        int sum=row[sr][sc+size-1]-(sc>0?row[sr][sc-1]:0);
        if(sum>t) return false;
        int s1=0;
        for(int i=sr;i<sr+size;i++)
        {
            s1=s1+row[i][sc+size-1]-(sc>0?row[i][sc-1]:0);
        }
         if(s1>t) return false;
         int s2=0;
        for(int i=sc;i<sc+size;i++)
        {
            s2=s2+col[sr+size-1][i]-(sr>0?col[sr-1][i]:0);
        }
         if(s2>t) return false;
         return true;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] row=new int[m][n];
        int[][] col=new int[m][n];
        for(int i=0;i<m;i++)
        {
            row[i][0]=mat[i][0];
            for(int j=1;j<n;j++)
            {
                row[i][j]=row[i][j-1]+mat[i][j];
            }
        }
        for(int i=0;i<n;i++)
        {
            col[0][i]=mat[0][i];
            for(int j=1;j<m;j++)
            {
                col[j][i]=col[j-1][i]+mat[j][i];
            }
        }
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int size=Math.min(m-i,n-j);
                for(int sz=size;sz>ans;sz--)
                {
                    if(isValid(i,j,sz,row,col,mat,threshold))
                    {
                        ans=sz;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}