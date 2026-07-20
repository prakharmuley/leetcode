
class Solution{
     public List<List<Integer>> shiftGrid(int[][] g, int k) {
        List<List<Integer>> res=new ArrayList<>();
       
         int n=g.length;
        int m=g[0].length; 
       
         int r[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {     
         for(int j=0;j<m;j++)
         {
           int new_col=(j+k)%m;
           int new_row=(i+(j+k)/m)%n;
             
           r[new_row][new_col]=g[i][j];
           
         }     
        }
        return (List)Arrays.asList(r);
    }
}



