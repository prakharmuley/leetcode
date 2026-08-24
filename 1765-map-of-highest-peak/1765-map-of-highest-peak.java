class Solution {
    public int[][] highestPeak(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        for(int[] d: dist) Arrays.fill(d,Integer.MAX_VALUE);
        int[] dir=new int[]{-1,0,1,0,-1};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                 if(grid[i][j]==1)
                 {
                    dist[i][j]=0;
                    grid[i][j]=-1;
                    q.offer(new int[]{i,j});
                 }
            }
        }
        
        int ans=0;
        while(!q.isEmpty())
        {
           int l=q.size();
           for(int i=0;i<l;i++)
           {
            int[] pair=q.poll();
            int x=pair[0];
            int y=pair[1];
            for(int d=0;d<4;d++)
            {
                int r=x+dir[d];
                int c=y+dir[d+1];
                if(r<0||c<0||r>=n||c>=m||dist[r][c]==0||grid[r][c]==-1) continue;
                if(dist[r][c]>dist[x][y])
                {
                  grid[r][c]=-1;  
                  q.offer(new int[]{r,c});
                  dist[r][c]=dist[x][y]+1;
                }   
            }
           }
        }
        return dist;
    }
}