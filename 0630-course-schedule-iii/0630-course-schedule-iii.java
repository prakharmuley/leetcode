class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);  
        int sum=0;
        for(int[] x: courses)
        {
            sum+=x[0];
            pq.offer(x[0]);
            if(sum>x[1]) sum-=pq.poll();
        }
        return pq.size();
    }
}