class Solution {
    public int maxFrequency(int[] nums, int k) {
        int l=0,r=0;
        int ans=0;
        long t=0;
        Arrays.sort(nums);
        while(r<nums.length)
        {
            t+=nums[r];
            while((long)nums[r]*(long)(r-l+1)>t+(long)k)
            {
                t=t-(long)nums[l];
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
        
    }
}