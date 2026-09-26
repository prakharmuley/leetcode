class Solution {
    private boolean dfs(int i, int j, String s, int k,char[][] arr, StringBuilder sb)
    {
        if(k==s.length()) return true;
        if(i<0||j<0||i>=arr.length||j>=arr[i].length||arr[i][j]=='#'||k>=s.length()) return false;
       
        boolean d=false;
        boolean u=false;
        boolean r=false;
        boolean l=false;
        char temp=arr[i][j];
        if(s.charAt(k)==arr[i][j])
        {
           arr[i][j]='#';
           d=dfs(i+1,j,s,k+1,arr,sb);
           u=dfs(i-1,j,s,k+1,arr,sb);
           r=dfs(i,j+1,s,k+1,arr,sb);
           l=dfs(i,j-1,s,k+1,arr,sb);
           arr[i][j]=temp;


        }
        return d||u||r||l;
    }
    public boolean exist(char[][] board, String word) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(i,j,word,0,board,sb)) return true;
                }
            }
        }
        return false;
    }
}