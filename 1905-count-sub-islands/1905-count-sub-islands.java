class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid2.length;
        int m=grid2[0].length;
        int ans=0;
        int[] dir=new int[]{-1,0,1,0,-1};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid2[i][j]==1)
                {
                    boolean f=true;
                    grid2[i][j]=0;
                    Queue<int[]> q=new LinkedList<>();
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty())
                    {
                        int[] p=q.poll();
                        int x=p[0];
                        int y=p[1];
                        if(x>=0&&y>=0&&x<n&&y<m&&grid1[x][y]==0)
                        {
                            f=false;
                        }
                        for(int d=0;d<4;d++)
                        {
                            int r=x+dir[d];
                            int c=y+dir[d+1];
                            if(r<0||c<0||r>=n||c>=m) continue;
                            if(grid2[r][c]==0)
                            {
                                continue;
                            }
                            grid2[r][c]=0;
                            q.offer(new int[]{r,c});

                        }
                    }
                    if(f) ans++; 
                }
            }
        }
        return ans;
    }
}