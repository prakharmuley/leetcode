class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int n=grid.length;
        int m=grid[0].length();
        char[][] arr=new char[n][m];
        for(int i=0;i<n;i++) arr[i]=grid[i].toCharArray();
        Queue<int[]> q=new LinkedList<>();
        boolean[][][] vis=new boolean[n][m][128];
        int key=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]=='@')
                {
                    q.offer(new int[]{i,j,0,0});
                    vis[i][j][0]=true;
                }
                else if(arr[i][j]!='#'&&Character.isLowerCase(arr[i][j]))
                 key++;
            }
        }
        int cnt=0;
        int[] dir=new int[]{-1,0,1,0,-1};
        while(!q.isEmpty())
        {
            int[] p=q.poll();
            int x=p[0];
            int y=p[1];
            int steps=p[2];
            int old_mask=p[3];
            for(int i=0;i<4;i++)
            {
                int row=x+dir[i];
                int col=y+dir[i+1];
                if(old_mask==(1<<key)-1) return steps; 
                if(row<0||col<0||row>=n||col>=m||arr[row][col]=='#'||vis[row][col][old_mask]) continue;
                char c=arr[row][col];
                if(Character.isUpperCase(c)) {
                    int new_mask=((old_mask)>>(c-'A'));
                    if((new_mask&1)!=0){
                    vis[row][col][old_mask]=true;
                    q.offer(new int[]{row,col,steps+1,old_mask});
                    }
                 }
                else if (Character.isLowerCase(c)) {
                    int new_mask=old_mask|(1<<(c-'a'));
                    vis[row][col][new_mask]=true;
                    q.offer(new int[]{row,col,steps+1,new_mask});

                }
                else
                {
                    
                    vis[row][col][old_mask]=true;
                    q.offer(new int[]{row,col,steps+1,old_mask});
                } 
            }
            
        
        }
        return -1;

    }
}