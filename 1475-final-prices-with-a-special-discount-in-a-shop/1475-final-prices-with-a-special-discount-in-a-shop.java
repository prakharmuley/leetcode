class Solution {
    public int[] finalPrices(int[] nums) {
        Stack<Integer> st=new Stack<>();
       
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&nums[st.peek()]>nums[i]) st.pop();
            ans[i]=st.isEmpty()?nums[i]:nums[i]-nums[st.peek()];

            st.push(i);
        }
        return ans;
    }
}