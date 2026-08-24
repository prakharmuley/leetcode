class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hs=new HashSet<>();
        Set<String> vis=new HashSet<>();
        for(String s: wordList) hs.add(s);
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
       // hs.add(beginWord);
       // hs.add(endWord);
        int ans=0;
        while(!q.isEmpty())
        {
            int l=q.size();
            for(int i=0;i<l;i++)
            {
                String cur=q.poll();
                if(cur.equals(endWord)) return ans+1;
                char[] arr=cur.toCharArray();
                for(int idx=0;idx<arr.length;idx++)
                {
                    char temp=arr[idx];
                    for(char c='a';c<='z';c++)
                    {
                       arr[idx]=c;
                       String str=new String(arr);
                       if(hs.remove(str))
                       {
                          q.offer(str);
                       }
                       
                      
                    }
                     arr[idx]=temp;
                   
                }
            }
            ans++;
        }
        return 0;
    }
}