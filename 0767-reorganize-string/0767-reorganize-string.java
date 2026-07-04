class Solution {
    public String reorganizeString(String s) {
        int h[]=new int[26];
        int l=s.length();
        StringBuilder sb=new StringBuilder();
        Pair p[]=new Pair[26];
        for(char c: s.toCharArray())  h[c-'a']++;
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->b.v-a.v);
        for(int i=0;i<26;i++) p[i]=new Pair((char)('a'+i),h[i]);
        for(Pair pp: p) {if(pp.v>0) pq.offer(pp);}
        if(pq.peek().v>(s.length()+1)/2) return "";
        while(pq.size()>1)
        {
            Pair pp1=pq.poll();
            Pair pp2=pq.poll();
            char ch1=pp1.c;
            int val1=pp1.v;
            char ch2=pp2.c;
            int val2=pp2.v;
            sb.append(ch1);
            sb.append(ch2);
            pp1.v--;
            pp2.v--;
            
            if(pp1.v>0)
            {
                pq.offer(pp1);
            }
            
             if(pp2.v>0)
            {
                pq.offer(pp2);
            }
        }
        if(!pq.isEmpty())
        {
            Pair pp=pq.poll();
            sb.append(pp.c);
        }
        return sb.toString();
    }
}
class Pair{
    char c;
    int v;
    public Pair(char c, int v)
    {
        this.c=c;
        this.v=v;
    }
}