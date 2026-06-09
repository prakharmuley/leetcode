class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int m1=arr.length,m2=arr.length;
        List<Integer> list=new ArrayList<>();
        int sum=0,j=0;
        int[] best=new int[arr.length];
        Arrays.fill(best,arr.length);
        int ans=arr.length+1;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            while(sum>target)
            {
                  sum-=arr[j];
                  j++;
            }
            if(sum==target)
            {
                int length=i-j+1;
                if(j>0&&best[j-1]!=arr.length+1)
                {
                    ans=Math.min(ans,best[j-1]+length);
                }
                best[i]=length;
            }
            if(i>0)
            {
                best[i]=Math.min(best[i],best[i-1]);
            }
        }
        return ans==arr.length+1?-1:ans;
       
        
    }
}