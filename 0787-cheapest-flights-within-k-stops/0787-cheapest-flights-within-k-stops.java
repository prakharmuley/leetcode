class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : flights)
            adj[e[0]].add(new int[]{e[1], e[2]});

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.offer(new int[]{src, k + 1, 0});
         int[] track=new int[n];
         Arrays.fill(track,-1);
        while (!pq.isEmpty()) {

            int[] p = pq.poll();

            int node = p[0];
            int kk = p[1];
            int cost = p[2];

            if (node == dst)
                return cost;

            if (kk == 0)
                continue;
            
            if(track[node]>=kk) continue;

            track[node]=kk;
            for (int[] next : adj[node]) {

                int nei = next[0];
                int price = next[1];

                pq.offer(new int[]{
                    nei,
                    kk - 1,
                    cost + price
                });
            }
        }

        return -1;
    }
}