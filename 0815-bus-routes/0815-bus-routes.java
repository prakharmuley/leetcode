class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target) return 0;
        int n=routes.length;
        Map<Integer,List<Integer>> mp=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> hs=new HashSet<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<routes[i].length;j++)
            {
                List<Integer> list=mp.getOrDefault(routes[i][j],new ArrayList<>());
                list.add(i);
                mp.put(routes[i][j],list);
            }
        }
        for(Integer x: mp.getOrDefault(source,new ArrayList<>()))
        {
            q.offer(x);
            hs.add(x);
        }
        int cnt=1;
        while(!q.isEmpty())
        {
            int l=q.size();
            for(int i=0;i<l;i++)
            {
                int p=q.poll();
                for(int x: routes[p])
                {
                    if(x==target) return cnt;
                     for(Integer ll: mp.getOrDefault(x, new ArrayList<>()))
                      {
                           if(!hs.contains(ll))
                           {
                            hs.add(ll);
                            q.offer(ll);
                           }
                      }
                }
               
            }
            cnt++;

        }
        return -1;
    }
}