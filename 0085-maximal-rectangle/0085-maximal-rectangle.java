class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int ans = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == '0') heights[j] = 0;
                else heights[j]++;
            }  
            ans = Math.max(ans,calcArea(heights));
        }
        return ans; 
    }
    public int calcArea(int[] h)
    {
        int rb[]=new int[h.length];
        Stack<Integer> st=new Stack<>();
        st.push(h.length-1);
        rb[h.length-1]=h.length;
        for(int i=h.length-2;i>=0;i--)
        {
            while(!st.isEmpty()&&h[i]<=h[st.peek()])
            {
                st.pop();
            }
            if(st.size()==0) rb[i]=h.length;
            else rb[i]=st.peek();
            
            st.push(i);
        }
        int lb[]=new int[h.length];
        st=new Stack<>();
        st.push(0);
        lb[0]=-1;
        for(int i=1;i<h.length;i++)
        {
            while(!st.isEmpty()&&h[i]<=h[st.peek()])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                lb[i]=-1;
            }
            else
                lb[i]=st.peek();
            
            st.push(i);
        }
        int ans=0;    
        for(int i=0;i<h.length;i++)
        {
            ans=Math.max(ans,(rb[i]-lb[i]-1)*h[i]);
        }
        return ans;
        
        
        
        
        
        
        
   
    }
}