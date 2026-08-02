class Solution {
    public void dfs(int r, int c, char[][] arr, int n, int m, boolean[][] vis)
    {
        if(r<0||c<0||r>=n||c>=m||vis[r][c]||arr[r][c]=='0') return;
        vis[r][c]=true;
        dfs(r+1,c,arr,n,m,vis);
        dfs(r-1,c,arr,n,m,vis);
        dfs(r,c+1,arr,n,m,vis);
        dfs(r,c-1,arr,n,m,vis);
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                  if(!vis[i][j])
                  {
                    dfs(i,j,grid,n,m,vis);
                    cnt++;
                  }
                }
            }
        }
        return cnt;
    }
}