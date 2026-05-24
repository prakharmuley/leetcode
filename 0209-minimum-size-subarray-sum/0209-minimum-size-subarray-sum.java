class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int l=0,r=0;
        int n=nums.length;
        int sum=0;
        int mxLen=n+1;
        int s=0;
        boolean f=false;
       
        while(r<n)
        {
            sum+=nums[r];
            while(sum>=k)
            {
                f=true;
                sum-=nums[l];
                mxLen=Math.min(r-l+1,mxLen);
                l++;
            }
            r++;
        }
      

        return mxLen==n+1?0:mxLen;
    }
}
// 2 3 1 2 4 3
// 2 5 6 8 12 15