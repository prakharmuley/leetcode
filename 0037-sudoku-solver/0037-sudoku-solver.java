class Solution {
    public boolean isValid(char[][] b, int r, int c, char ch)
    {
        int n=b.length;
        int m=b[0].length;
        for(int i=0;i<n;i++) 
        {
            if(b[i][c]==ch) return false;
            if(b[r][i]==ch) return false;
            if(b[3*(r/3)+i/3][3*(c/3)+i%3]==ch) return false;
        }
        
        return true;

    }
    public void solveSudoku(char[][] board) {
       solve(board);
    }
    public boolean solve(char[][] arr)
    {
         int n=arr.length;
         int m=arr[0].length;
         for(int i=0;i<n;i++)
         {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]=='.')
                {             
                   for(char c='1';c<='9';c++)
                   {
                      
                      if(isValid(arr,i,j,c)) {
                          arr[i][j]=c;
                         if(solve(arr)) return true;
                         else 
                         {
                            arr[i][j]='.';
                         }
                      }
                   }
                   return false;
                }
            }
         }
         return true;
    }
    
}