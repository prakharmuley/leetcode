class Solution {
    public int fun(int[] arr, int k)
    {
        int i=0,j=0;
        if(k<0) return 0;
        int n=arr.length;
        int ans=0;
        int sum=0;
        while(j<n)
        {
              sum+=arr[j];
              while(sum>k)
              {
                sum-=arr[i];
                i++;
              }
             
              ans+=(j-i+1);
               j++;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return fun(nums,goal)-fun(nums,goal-1);
    }
}