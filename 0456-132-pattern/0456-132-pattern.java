class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int f1=0;
        int f2=0;
        int x=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(x>nums[i]) return true;
            while(!st.isEmpty()&&st.peek()<nums[i])
            {
               x=st.pop();     
                
            }
          
            st.push(nums[i]);
        }
        return false;
    }
}