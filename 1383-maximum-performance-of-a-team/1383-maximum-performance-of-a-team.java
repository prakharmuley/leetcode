class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod=1_000_000_007;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Pair pair[]=new Pair[n];
        for(int i=0;i<n;i++) 
        {
         pair[i]=new Pair(speed[i],efficiency[i]);
        }
        Arrays.sort(pair,(p1,p2)->Integer.compare(p2.e,p1.e));
        long ans=0L;
        long res=0L;
        for(Pair p: pair)
        {
            if(pq.size()==k)
            {
                ans-=pq.poll();
            }
            ans=((ans)+(p.s));
            pq.offer(p.s);
           
            res=Math.max(res,(ans*p.e));
           
        }
        
        return (int)(res%mod);
        
        
    }
}
class Pair{
    int s;
    int e;
    public Pair(int s, int e)
    {
        this.s=s;
        this.e=e;
    }
}