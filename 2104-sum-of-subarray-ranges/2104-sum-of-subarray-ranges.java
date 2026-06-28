class Solution {
    public long subArrayRanges(int[] nums) {
       Stack<Integer> sts=new Stack<>();
       Stack<Integer> stg=new Stack<>();
       int n=nums.length;
       int[] nge=new int[n];
       int[] nse=new int[n];
       int[] pge=new int[n];
       int[] pse=new int[n];
       // prevous greatest smallest
       for(int i=0;i<n;i++)
       {
         while(!stg.isEmpty()&&nums[stg.peek()]<nums[i])
         {
            stg.pop();
         }
         pge[i]=stg.isEmpty()?-1:stg.peek();
         stg.push(i);

         while(!sts.isEmpty()&&nums[sts.peek()]>nums[i])
         {
            sts.pop();
         }
         pse[i]=sts.isEmpty()?-1:sts.peek();
         sts.push(i);
       }
        sts=new Stack<>();
        stg=new Stack<>();

        //next greatest smallest
       for(int i=n-1;i>=0;i--)
       {
         while(!stg.isEmpty()&&nums[stg.peek()]<=nums[i])
         {
            stg.pop();
         }
         nge[i]=stg.isEmpty()?n:stg.peek();
         stg.push(i);

         while(!sts.isEmpty()&&nums[sts.peek()]>=nums[i])
         {
            sts.pop();
         }
         nse[i]=sts.isEmpty()?n:sts.peek();
         sts.push(i);
       }
       long ans = 0;

        for (int i = 0; i < n; i++) {

            long min = (long) (i - pse[i]) * (nse[i] - i);
            long max = (long) (i - pge[i]) * (nge[i] - i);

            ans += max * nums[i];
            ans -= min * nums[i];
        }

        return ans;

    }
}