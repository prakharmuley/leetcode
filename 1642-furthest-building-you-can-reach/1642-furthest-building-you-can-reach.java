class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int prev=heights[0];
        int n=heights.length;
        int idx=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=1;i<n;i++)
        {
            if(prev>=heights[i])
            {
                prev=heights[i];
                idx=i;
                continue;

            }
            int diff=heights[i]-prev;
            pq.offer(diff);
            prev=heights[i];
            bricks-=diff;
            if(bricks<0)
            {
                if(ladders==0)
                {
                    return i-1;
                }
                bricks+=pq.poll();
                ladders--;
            }
            
        }
        return n-1;
    }
}