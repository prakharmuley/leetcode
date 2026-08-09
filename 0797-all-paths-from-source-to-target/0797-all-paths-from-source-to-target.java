class Solution {
    private void dfs(int root, int tar, List<Integer>[] adj, boolean[] vis, List<List<Integer>> ans, List<Integer> l)
    {
        l.add(root);

        if(root==tar)
        {      
            ans.add(new ArrayList<>(l));
                              l.remove(l.size()-1);

            return;
        }
        
        for(int x: adj[root])
        {
          dfs(x,tar,adj,vis,ans,l);
        }
                  l.remove(l.size()-1);

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        int n=graph.length;
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int x: graph[i])
            {
                adj[i].add(x);
            }
        }
        boolean[] vis=new boolean[n];
        dfs(0,n-1,adj,vis,list, new ArrayList<>());
        return list;
    }
}