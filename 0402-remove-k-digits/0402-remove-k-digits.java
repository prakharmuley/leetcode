class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int n=num.length();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&k>0&&num.charAt(st.peek())>num.charAt(i))
            {
                st.pop();
                k--;
            }
             
            st.push(i);
        }
        while(!st.isEmpty()&&k>0)
        {
            st.pop();
            k--;
        }
        while(!st.isEmpty()) sb.append(num.charAt(st.pop()));
        sb.reverse();

        while(sb.length()>0 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString().length()==0?"0":sb.toString();
    }
}

//1234

//1423
//1342
//1344 


//   1 4 3 2 2 1 9
//   1 4 4 3 3 2 9
//   4 9 9 9 9 9 9