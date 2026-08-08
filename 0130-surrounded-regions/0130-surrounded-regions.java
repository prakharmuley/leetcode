class Solution {
    
    int n;
    int m;
    public void dfs(int i, int j, char[][] arr, int n, int m, boolean[][] vis)
    {
        if(i<0||j<0||i>=n||j>=m||arr[i][j]=='X'||vis[i][j]) return;
        vis[i][j]=true;
        dfs(i+1,j,arr,n,m,vis);
        dfs(i-1,j,arr,n,m,vis);
        dfs(i,j+1,arr,n,m,vis);
        dfs(i,j-1,arr,n,m,vis);


    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++)
        {

            if(i<m&&board[0][i]=='O')
            {
                dfs(0,i,board,n,m,vis);
            }
            if(i<m&&board[n-1][i]=='O')
            {
                dfs(n-1,i,board,n,m,vis);
            }
          
            if(board[i][0]=='O')
            {
                dfs(i,0,board,n,m,vis);
            }
             if(board[i][m-1]=='O')
            {
                dfs(i,m-1,board,n,m,vis);
            }
        }
        for(int i=1;i<n-1;i++)
        {
            for(int j=1;j<m-1;j++)
            {
                
                if(!vis[i][j]) 
                  board[i][j]='X';

                
                
            }
        }
    }
}