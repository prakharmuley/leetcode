class Solution {

    static char addOne(char c) {
    return (char) ('0' + (c - '0' + 1) % 10);
    }

    static char subtractOne(char c) {
    return (char) ('0' + (c - '0' + 9) % 10);
    }

    public int openLock(String[] deadends, String target) {
        Queue<String> q=new LinkedList<>();
        int cnt=0;
        Set<String> hs=new HashSet<>();
        for(String s: deadends) hs.add(s);
        q.offer(target);
        while(!q.isEmpty())
        {
            int l=q.size();
            for(int j=0;j<l;j++)
            {
                String cur=q.poll();
                if(cur.equals("0000")) return cnt;
                char[] ch=cur.toCharArray();
                for(int i=0;i<ch.length;i++)
                {
                    char temp=ch[i];
                    ch[i]=(char) ('0' + (ch[i] - '0' + 1) % 10);
                    if(!hs.contains(new String(ch))){
                       q.offer(new String(ch));
                       hs.add(new String(ch));
                    }
                    ch[i]=temp;
                    ch[i]=(char) ('0' + (ch[i] - '0' + 9) % 10);
                    if(!hs.contains(new String(ch))){
                      q.offer(new String(ch));
                      hs.add(new String(ch));
                    }
                    ch[i]=temp;

                    
                }
            }
            cnt++;
        }
        return -1;
    }
}