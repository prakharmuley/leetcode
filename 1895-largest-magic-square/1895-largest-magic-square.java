class Solution {
    public boolean isValid(int x, int y,int size,int[][] row, int[][] col, int[][] arr )
    {
        int target=row[x][y+size-1]-(y>0?row[x][y-1]:0);
        for(int i=x;i<x+size;i++)
        {
            if(target!=(row[i][y+size-1]-(y>0?row[i][y-1]:0))) return false;
        }
         for(int i=y;i<y+size;i++)
        {
            if(target!=(col[x+size-1][i]-(x>0?col[x-1][i]:0))) return false;
        }
        int dg1=0,dg2=0;
        for(int i=0;i<size;i++)
        {
            dg1+=arr[x+i][y+i];
        }
        if(dg1!=target) return false;

        for(int i=0;i<size;i++)
        {
            dg2+=arr[x+i][y+size-1-i];
        }
        if(dg2!=target) return false;
        return true;
        
    }
    public int largestMagicSquare(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] row=new int[n][m];
        int[][] col=new int[n][m];
        for(int i=0;i<n;i++)
        {
            row[i][0]=grid[i][0];
            for(int j=1;j<m;j++)
            {
                row[i][j]=row[i][j-1]+grid[i][j];
            }
        }

        for(int i=0;i<m;i++)
        {
            col[0][i]=grid[0][i];
            for(int j=1;j<n;j++)
            {
                col[j][i]=col[j-1][i]+grid[j][i];
            }
        }
        int ans=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int size=Math.min(n-i,m-j);
                for(int sz=size;sz>1;sz--)
                {
                        if(isValid(i,j,sz,row,col,grid))
                        {
                            ans=Math.max(ans,sz);
                            break;
                        }
                }
                
            }
           
        }
        return ans==0?1:ans;
    }
}

/*
5 1 3 1
9 3 3 1
1 3 3 8


5 6  9  10
9 12 15 16
1 4   7 15


5  1  3  1
14 4  6  2
15 7  9  10




*/