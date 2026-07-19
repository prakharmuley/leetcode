class Solution {
    int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean bfs(int[] src, int t, int[] tar, Set<String> hs )
    {
        Queue<int[]> q=new LinkedList<>();
        if(hs.contains(String.valueOf(src[0])+"-"+String.valueOf(src[1])))
             return false; 

        Set<String> vis=new HashSet<>();
        vis.add(String.valueOf(src[0])+"-"+String.valueOf(src[1]));
        q.offer(new int[]{src[0],src[1]});
        while(!q.isEmpty())
        {
            int[] p=q.poll();
            if(p[0]==tar[0]&&p[1]==tar[1]) return true;
            if(vis.size()>t) return true;
            for(int[] d: dir)
            {
                int x=p[0]+d[0];
                int y=p[1]+d[1];
                String s=String.valueOf(x)+"-"+String.valueOf(y);
                if((x<0||y<0||x>=1000000||y>=1000000)||vis.contains(s)||hs.contains(s)) 
                {
                    continue;
                }
                q.offer(new int[]{x,y});
                vis.add(s);
            }

        }
        return false;

    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> hs=new HashSet<>();
        for(int[] b: blocked)
        {
            String s=String.valueOf(b[0]+"-"+b[1]);
            hs.add(s);
        }
        int n=blocked.length;
        int threshold=(n*(n-1))/2;
        boolean l=bfs(source,threshold,target,hs);
        boolean r=bfs(target,threshold,source,hs);
        return l&&r;
    }
}