class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int ans=0;
        char d[]=new char[]{'A','C','G','T'};
        Queue<String> q=new LinkedList<>();
        q.offer(start);
        Map<String,Integer> mp=new HashMap<>();
        for(String s: bank) mp.put(s,1);
        while(!q.isEmpty())
        {
            int l=q.size();
            for(int j=0;j<l;j++)
            {
                char[] cur=q.poll().toCharArray();
                if(new String(cur).equals(end)) return ans;
                for(int i=0;i<cur.length;i++)
                {
                    char temp=cur[i];
                    int idx=i;
                    for(int k=0;k<d.length;k++)
                    {
                        if(temp==d[k]) continue;
                        cur[idx]=d[k];
                        if(mp.containsKey(new String(cur)))
                        {
                            q.offer(new String(cur));
                            mp.remove(new String(cur));
                        }
                    }
                    cur[idx]=temp;
                    
                }
            }
            ans++;
        }
        return -1;
    
    
    
    }
}