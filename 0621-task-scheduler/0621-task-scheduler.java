class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(); 
        Set<Integer> s=new HashSet<>();
        int[] f=new int[26];
        int mx=0;
        int idx=-1;
        for(char c: tasks) f[c-'A']++;
        Arrays.sort(f);
        int ans=0;
        int gaps=(f[25]-1)*n;
        for(int i=24;i>=0;i--)
        {
            gaps-=Math.min(f[i],f[25]-1);
        }
        
        
        return tasks.length+Math.max(0,gaps);
    }
}