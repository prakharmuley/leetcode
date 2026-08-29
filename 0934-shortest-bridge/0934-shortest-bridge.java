class Solution {
    public void dfs(int i, int j,int n, int m, int area, int[][] grid, boolean[][] vis)
    {
           if(i<0||j<0||i>=n||j>=m||grid[i][j]==0||grid[i][j]==area) return;
           grid[i][j]=area;
           vis[i][j]=true;
           dfs(i+1,j,n,m,area,grid,vis);
           dfs(i,j+1,n,m,area,grid,vis);
           dfs(i-1,j,n,m,area,grid,vis);
           dfs(i,j-1,n,m,area,grid,vis);
    }
    public int shortestBridge(int[][] grid) {
        int[] dir=new int[]{-1,0,1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        for(boolean[] b: vis) Arrays.fill(b,false);
        int area=2;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1&&!vis[i][j])
                {
                    dfs(i,j,n,m,area,grid,vis);
                    area++;
                }
            }
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2) q.offer(new int[]{i,j,2,0});
            }
        }
        int ans=0;
        vis=new boolean[n][m];
        while(!q.isEmpty())
        {
            int l=q.size();
            for(int i=0;i<l;i++)
            {
                int[] pair=q.poll();
                int x=pair[0];
                int y=pair[1];
                int p=pair[2];
                int step=pair[3];
                if(grid[x][y]==3) return step-1;
                for(int j=0;j<4;j++)
                {
                    int r=x+dir[j];
                    int c=y+dir[j+1];
                    if(r<0||c<0||r>=n||c>=m||vis[r][c])
                    {
                        continue;
                    }
                    vis[r][c]=true;
                    q.offer(new int[]{r,c,grid[r][c],step+1});
                }
            }           
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
            System.out.print("\n");
        }
        return 0;


    }
}