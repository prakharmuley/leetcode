class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,grid[0][0]});
        int[] dir=new int[]{-1,0,1,0,-1};
        boolean[][] vis=new boolean[n][m];
        while(!pq.isEmpty())
        {
            int[] pair=pq.poll();
            int x=pair[0];
            int y=pair[1];
            int elevation=pair[2];
            if(x==n-1&&y==m-1) return elevation;

            for(int i=0;i<4;i++)
            {
                int r=x+dir[i];
                int c=y+dir[i+1];
                if(r<0||c<0||r>=n||c>=m||vis[r][c]) continue;
                vis[r][c]=true;
                pq.offer(new int[]{r,c,Math.max(elevation,grid[r][c])});

            }

        }
        return -1;
    }
}