class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]==0?b[1]-a[1]:a[0]-b[0]);
        List<int[]> list=new ArrayList<>();
        int mn=arr[0][0];
        int n=arr.length;
        int mx=arr[0][1];
        for(int i=1;i<n;i++)
        {
              if(mx>=arr[i][0])
              {
                mx=Math.max(mx,arr[i][1]);
                
              }
              else
              {
               list.add(new int[]{mn,mx});
               mn=arr[i][0];
               mx=arr[i][1];

              }
        }
         list.add(new int[]{mn,mx});
        int[][] ans = list.toArray(new int[list.size()][]);
        return ans;
    }
}