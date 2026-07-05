class Solution {
    public int[][] reconstructQueue(int[][] arr) {
        int n=arr.length;
        int[][] ans=new int[n][2];
        List<int[]> list=new ArrayList<>();
        Arrays.sort(arr,(a,b)->b[0]-a[0]==0?a[1]-b[1]:b[0]-a[0]);
        for(int[] x: arr)
        {
            list.add(x[1],x);
        }
        return list.toArray(new int[n][2]);
    }
    
}