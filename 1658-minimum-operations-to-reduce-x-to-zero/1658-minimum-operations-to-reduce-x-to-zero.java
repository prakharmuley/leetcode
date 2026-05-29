class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0,ans=-1,n=nums.length;
        int t=-x,l=0;
        for(int i: nums) t+=i;
        if(t==0) return n;
        if(t<0) return -1;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            while(sum>t) 
            {
                sum-=nums[l++];
            }
            if(sum==t)
                ans=Math.max(ans,i-l+1);
           
        }
        return ans==-1?-1:n-ans;
    }
}