class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MIN_VALUE);
        Stack<Integer> st=new Stack<>();
        int mxi=-1;
        int mx=Integer.MIN_VALUE;
        int i=0;
        for(int x: nums) 
        {
            if(x>mx)
            {
                mx=x;
                mxi=i;
            }

            i++;
        }
       
        i=0;
       
          for(i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&nums[st.peek()]<=nums[i])
              st.pop();
            if(st.isEmpty())
            {
                ans[i]=Integer.MIN_VALUE;
            }
            else
            {
                ans[i]=nums[st.peek()];
            }
            st.push(i);  
        }
         st=new Stack<>();
         for(int j=2*n-1;j>=0;j--)
        {
         i=j%n;
            while(!st.isEmpty()&&nums[st.peek()]<=nums[i])
              st.pop();
            if(st.isEmpty())
            {
                if(ans[i]==Integer.MIN_VALUE)
                {
                    ans[i]=-1;
                }
                
            }
            else
               ans[i]=nums[st.peek()];
             
            st.push(i);
        }
        return ans;
    }
}