class Solution {
    public void dfs(int[] prev, int[][] arr, Set<int[]> hs)
    {
        hs.add(prev);
        for(int[] cur: arr)
        {
            if(!hs.contains(cur))
            {
                long y=cur[1]-prev[1];
                long x=cur[0]-prev[0];
                long yy=y*y;
                long xx=x*x;
                long p=prev[2];
                long r=p*p;
                if(r>=xx+yy)
                {
                    dfs(cur,arr,hs);
                }
            }
        }
    }
    public int maximumDetonation(int[][] bombs) {
        
        int ans=0;
        for(int[] s: bombs)
        {
            Set<int[]> hs=new HashSet<>();
            dfs(s,bombs,hs);
            ans=Math.max(ans,hs.size());
            
        }
        return ans;
    }
}