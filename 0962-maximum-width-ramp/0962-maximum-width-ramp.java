class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        int i=0;
        for( i=0;i<nums.length;i++)
        {
            if(st.isEmpty()||nums[st.peek()]>nums[i]) st.push(i);
        }
        for(i=nums.length-1;i>=0;i--)
        {
             while(!st.isEmpty()&&nums[st.peek()]<=nums[i])
             {
                ans=Math.max(ans,i-st.peek());
                st.pop();
             }

             st.push(i);
        }
     
        return ans;
    }
}