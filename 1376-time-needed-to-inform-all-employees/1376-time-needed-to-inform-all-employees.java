class Solution {
    public int dfs(int root, int[] time, int[] arr, List<Integer>[] adj)
    {
        int mx=0;
        for(int x: adj[root])
        {
            mx=Math.max(mx,dfs(x,time,arr,adj));
        }
        return mx+time[root];
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(manager[i]!=-1)
            {
                adj[manager[i]].add(i);
            }
        }
       return dfs(headID,informTime,manager,adj);
    }
}