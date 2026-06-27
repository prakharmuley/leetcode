class StockSpanner {
     Stack<int[]> st;
     Stack<Integer> stt;
     int i;

    public StockSpanner() {
        st=new Stack<>();
        i=0;
    }
    
    public int next(int price) {
       
        while(!st.isEmpty()&&st.peek()[0]<=price)
        {
            st.pop();
           
        }
        int ans=1;
        ++i;
        if(!st.isEmpty())
        {
            ans=i-st.peek()[1];
            st.push(new int[]{price,i});
        }
        else
        {
            st.push(new int[]{price,i});
            ans=i;
        }
        
         
        return ans;

    }
}
// 100 80 60 70 60 75 85
                 
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */