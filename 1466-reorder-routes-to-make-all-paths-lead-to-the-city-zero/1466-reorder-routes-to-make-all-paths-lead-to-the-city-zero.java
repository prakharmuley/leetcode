class Solution {
    public void dfs(int root, List<Integer>[] adj, Set<String> hs, Set<Integer> vis, int[] a)
    {
        vis.add(root);
        for(int x: adj[root])
        {
            if(!vis.contains(x))
            {
                String s=String.valueOf(root)+">"+String.valueOf(x);
                if(hs.contains(s))
                {
                    a[0]++;
                }
                dfs(x,adj,hs,vis,a);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        int[] ans=new int[1];
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        Set<String> hs=new HashSet<>();
        Set<Integer> vis=new HashSet<>();
        for(int[] e: connections)
        {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
            String s=String.valueOf(e[0])+">"+String.valueOf(e[1]);
            hs.add(s);
        }
        dfs(0,adj,hs,vis,ans);
        return ans[0];
        
    }
}