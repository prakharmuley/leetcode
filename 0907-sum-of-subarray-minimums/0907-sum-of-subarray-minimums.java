class Solution {
    public int sumSubarrayMins(int[] arr) {
        long ans=0L;
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int mod=(int)1e9+7;
        int[] nsr=new int[n];
        int[] nsl=new int[n];
        nsl[0]=-1;
        nsr[n-1]=n;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&arr[st.peek()]>arr[i])
            {
                st.pop();
            }
            nsl[i]=st.isEmpty()?-1:st.peek();

            st.push(i);
        }
         st=new Stack<>();
         for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
            {
                st.pop();
            }
            nsr[i]=st.isEmpty()?n:st.peek();

            st.push(i);
        }
        for(int i=0;i<n;i++)
        {
            int left=(i-nsl[i]);
            int right=(nsr[i]-i);
            long ways=(left*right)%mod;
            ways=ways*arr[i];
            ways%=mod;
            ans=((ans%mod)+(ways%mod))%mod;
        }
        return (int)ans;
    }
}