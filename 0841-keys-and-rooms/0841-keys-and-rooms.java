class Solution {
    public void dfs(int node, List<Integer>[] adj, boolean[] vis)
    {
        vis[node]=true;
        for(Object x : adj[node])
        {
            int next = (int)x;

            if(!vis[next])
                dfs(next, adj, vis);
        }

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        boolean[] vis=new boolean[n];
        for(int i=0;i<rooms.size();i++)
        {
            for(int x: rooms.get(i))
            {
                adj[i].add(x);
            }
        }
         dfs(0,adj,vis);
         for(int i = 0; i < n; i++)
        {
            if(!vis[i])
                return false;
        }

        return true;
    }
}