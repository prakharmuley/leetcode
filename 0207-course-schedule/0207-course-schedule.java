class Solution {
    public boolean dfs(int node, int tar, List<Integer>[] adj, boolean[] v1, boolean[] v2)
    {
        v1[node]=true;
        v2[node]=true;
        for(int x: adj[node])
        {
           if(!v1[x])
           {
             if(!dfs(x,tar,adj,v1,v2)) return false;
           }
           else
           {

                if(v2[x]) return false;
            
           }
        }
        v2[node]=false;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] arr) {
        int n=arr.length;
        boolean vis1[]=new boolean[numCourses];
        boolean vis2[]=new boolean[numCourses];
        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            adj[i]=new ArrayList<>();
        }
        for(int[] e: arr)
        {
            adj[e[1]].add(e[0]);
        }
        for(int i=0;i<numCourses;i++){
          if(!vis1[i])
           if(!dfs(i,numCourses-1,adj,vis1,vis2)) return false;
        }
        return true;
    }
}