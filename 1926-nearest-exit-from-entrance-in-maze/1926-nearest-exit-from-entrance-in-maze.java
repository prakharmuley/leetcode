class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q=new LinkedList<>();
        int n=maze.length;
        int m=maze[0].length;
        maze[entrance[0]][entrance[1]]='+';
        q.offer(new int[]{entrance[0],entrance[1]});
        int[] dir=new int[]{-1,0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty())
        {
            int l=q.size();
            cnt++;
            for(int i=0;i<l;i++)
            {
                int[] p=q.poll();
                int x=p[0],y=p[1];
                for(int d=0;d<4;d++)
                {
                    int r=x+dir[d];
                    int c=y+dir[d+1];
                    if(r<0||c<0||r>=n||c>=m||maze[r][c]=='+') continue;
                    maze[r][c]='+';
                    if(r==n-1||c==m-1||r==0||c==0)
                    {
                       return cnt;
                    }
                    q.offer(new int[]{r,c});
                }
            }
        }
        return -1;
       
    }
}