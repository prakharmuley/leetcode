class Solution {
    public boolean dfs(int i, int j, int n, int m, int[][] grid, int[] a, boolean[][] vis)
    {
        if(i<0||j<0||i>=n||j>=m)
        {
            return false;
        }
        if(grid[i][j]==1||vis[i][j])
        {
            return true;
        }
        vis[i][j]=true;
        boolean x= dfs(i+1,j,n,m,grid,a,vis);
        boolean y= dfs(i-1,j,n,m,grid,a,vis);
        boolean c= dfs(i,j+1,n,m,grid,a,vis);
        boolean d= dfs(i,j-1,n,m,grid,a,vis);
        return x&&y&&c&&d;

    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!vis[i][j]&&grid[i][j]==0)
                {
                    if(dfs(i,j,n,m,grid,new int[1],vis))
                      ans++;
                }
            }
        }
        return ans;
    }
}