class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int[] arr=new int[n];
        int ans=0;
        int[] nsr=new int[n];
        int[] nsl=new int[n];
       
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
              nsr[i]=st.peek();
            else nsr[i]=n;
            st.push(i);

        }
        st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(!st.isEmpty())
              nsl[i]=st.peek();
            else nsl[i]=-1;
            
            st.push(i);

        }
         for(int i=0;i<heights.length;i++)
        {
              ans=Math.max(ans,(nsr[i]-nsl[i]-1)*heights[i]);
        }
        return ans;
        
    }
}
// 2 1 5 6 2 3
// 1 0 2 2 0 0
// 0 0 1 5 2 3