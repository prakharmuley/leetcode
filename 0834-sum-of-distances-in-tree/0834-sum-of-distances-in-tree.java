class Solution {
    int n;
    int root_0;
    public int dfs(int root, int par, List<Integer>[] adj, int[] count, int[] res, int dist)
    {
        int total=1;
        root_0+=dist;
        for(int x: adj[root])
        {
            if(x!=par)
            {
                total+=dfs(x,root,adj,count,res,dist+1);
            }
        }
        count[root]=total;
        return total;
    }

     public void dfss(int root, int par, List<Integer>[] adj, int[] count, int[] res)
    {
        for(int x: adj[root])
        {
            if(x!=par)
            {
                res[x]=res[root]-count[x]+(n-count[x]);
                dfss(x,root,adj,count,res);
            }
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] adj=new ArrayList[n];
        this.n=n;
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] e: edges)
        {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int[] count=new int[n];
        int[] res=new int[n];
        root_0=0;
        dfs(0,-1,adj,count,res,0);
        res[0]=root_0;

        dfss(0,-1,adj,count,res);
        return res;

    }
}