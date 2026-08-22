class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n=friends.length;
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<friends[i].length;j++)
            {
                adj[i].add(friends[i][j]);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Map.Entry<String,Integer>> list=new ArrayList<>();
        List<String> ans=new ArrayList<>();
        Set<Integer> hs=new HashSet<>();
        Map<String,Integer> mp=new HashMap<>();
        q.offer(id);
        hs.add(id);
        int cnt=0;
        while(!q.isEmpty())
        {
            int l=q.size();
            if(cnt==level+1)
            {
                break;
            }
            for(int i=0;i<l;i++)
            {
                int p=q.poll();
                if(cnt==level)
                {
                    List<String> ll=watchedVideos.get(p);
                    for(String s: ll) mp.put(s,mp.getOrDefault(s,0)+1);
                }
                for(int x: adj[p])
                {
                   if(!hs.contains(x)){
                      q.offer(x);
                      hs.add(x);
                   }
                      
                }
            }
            cnt++;
        }
        list.addAll(mp.entrySet());
        Collections.sort(list, (a, b) -> {
    if (a.getValue() != b.getValue()) {
        return a.getValue() - b.getValue();
    }
    return a.getKey().compareTo(b.getKey());
});
        for(Map.Entry<String,Integer> mpp: list)
        {
            ans.add(mpp.getKey());
        }
        return ans;
        
    }
}
class Pair{
    String c;
    int f;
    public Pair(String c, int f)
    {
        this.c=c;
        this.f=f;
    }
}