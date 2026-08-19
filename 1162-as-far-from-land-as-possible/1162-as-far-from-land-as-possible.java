class Solution {
    int d[]={0,-1,0,1,0};

  
    public int maxDistance(int[][] g) {
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<g.length;i++)
        {
            for(int j=0;j<g[0].length;j++)
            {
                if(g[i][j]==1)
                {
                    q.offer(new Pair(i,j));
                }
            }
        }
        if(q.size()==0 || q.size()==g.length*g[0].length){
            return -1;
        }
            int ans=-1;
       while(!q.isEmpty())
       {
           ans++;
           int l=q.size();
           
           
           for(int j=0;j<l;j++)
           {
           Pair p=q.poll();
           int r=p.x;
           int c=p.y;
           System.out.print(r+" "+c+"    "+ans+"\n");
              
           for(int i=0;i<4;i++)
           {
               int rr=r+d[i];
               int cc=c+d[i+1];
               if(rr>=0&&rr<g.length&&cc>=0&&cc<g[0].length&&g[rr][cc]==0)
               {
                   g[rr][cc]=1;
                   q.offer(new Pair(rr,cc));
               }
           }
           }
           
       }
        return ans;
    }
}
class Pair{
    int x;
    int y;
    public Pair(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
        
}